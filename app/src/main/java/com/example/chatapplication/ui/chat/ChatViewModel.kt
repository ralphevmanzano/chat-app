package com.example.chatapplication.ui.chat

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chatapplication.data.ChatRepository
import com.example.chatapplication.data.models.Chat
import com.example.chatapplication.data.models.ChatType
import com.example.kotlin_starter_app.ui.BaseViewModel
import com.example.todo_app.util.Event
import com.google.firebase.firestore.Query
import javax.inject.Inject

class ChatViewModel @Inject constructor(private val repository: ChatRepository) : BaseViewModel() {

  lateinit var userName: String

  val message = MutableLiveData<String>()

  private val _chats = MutableLiveData<List<Chat>>().apply { value = emptyList() }
  val chats: LiveData<List<Chat>> = _chats

  fun setup(userName: String?) {
    if (userName == null) return
    Log.d("Chat", "Username is: $userName")
    this.userName = userName
    getChats()
  }

  fun onSendClick() {
    if (userName.isEmpty() || message.value.isNullOrEmpty()) return
    val chat = Chat(userName = userName, message = message.value)

    clearTextField()

    repository.addMessage(chat).addOnSuccessListener {
      Log.d("Chat", "Added new message!")
    }.addOnFailureListener {
      Log.e("Chat", "Error adding message!")
    }
  }

  private fun clearTextField() {
    message.value = ""
  }

  private fun getChats() {
    repository.getMessages().orderBy("timestamp", Query.Direction.ASCENDING)
      .addSnapshotListener { value, e ->

        if (value?.documents?.size == chats.value?.size) return@addSnapshotListener
        if (e != null) {
          Log.e("Chat", "Listen Failed!", e)
          return@addSnapshotListener
        }

        val tempChats = mutableListOf<Chat>()

        for (doc in value?.documents!!) {
          val chat = Chat.fromDocumentSnapshot(doc)
          setChatType(chat)
          tempChats.add(chat)
        }

        _chats.value = tempChats
      }
  }

  private fun setChatType(chat: Chat) {
    if (this.userName == chat.userName) {
      chat.chatType = ChatType.mine
      chat.senderLabel = "You"
    } else {
      chat.chatType = ChatType.theirs
    }
  }

}
