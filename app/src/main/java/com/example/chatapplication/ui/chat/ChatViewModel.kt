package com.example.chatapplication.ui.chat

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chatapplication.data.ChatRepository
import com.example.chatapplication.data.models.Chat
import com.example.kotlin_starter_app.ui.BaseViewModel
import com.google.firebase.firestore.Query
import javax.inject.Inject

class ChatViewModel @Inject constructor(private val repository: ChatRepository) : BaseViewModel() {

  lateinit var userName: String

  val message = MutableLiveData<String>()

  private val _chats = MutableLiveData<List<Chat>>().apply { value = emptyList() }
  val chat: LiveData<List<Chat>> = _chats

  fun setup(userName: String?) {
    if (userName == null) return
    Log.d("Chat", "Username is: $userName")
    this.userName = userName
    getChats()
  }

  fun onSendClick() {
    if (userName.isEmpty() && message.value.toString().isEmpty()) return
    val chat = Chat(userName, message.value.toString())

    repository.addMessage(chat).addOnSuccessListener {
      Log.d("Chat", "Added new message!")
    }.addOnFailureListener {
      Log.e("Chat", "Failed adding message")
    }
  }

  fun getChats() {
    repository.getMessages().orderBy("timestamp", Query.Direction.ASCENDING).addSnapshotListener { value, e ->
      if (e != null) {
        Log.e("Chat", "Listen Failed!", e)
        return@addSnapshotListener
      }
      val tempChats = mutableListOf<Chat>()

      for (doc in value?.documents!!) {
        val chat = doc.toObject(Chat::class.java)
        Log.d("Chat", chat.toString())
        chat?.let { tempChats.add(it) }
      }
      Log.d("Chat", tempChats.toString())
      _chats.value = tempChats
    }
  }

}
