package com.example.chatapplication.data

import android.util.Log
import com.example.chatapplication.data.models.Chat
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class ChatRepository @Inject constructor() {
  private val ref = FirebaseFirestore.getInstance().collection("messages")

  fun getMessages(): CollectionReference {
    return ref
  }

  fun addMessage(chat: Chat): Task<DocumentReference> {
    val chatMap = HashMap<String, Any>()
    chatMap["userName"] = chat.userName.toString()
    chatMap["message"] = chat.message.toString()
    chatMap["timestamp"] = FieldValue.serverTimestamp()
    return ref.add(chatMap)
  }

}