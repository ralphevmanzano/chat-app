package com.example.chatapplication.data.models

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import java.sql.Timestamp

enum class ChatType { mine, theirs }
data class Chat(
  val id: String? = null,
  val userName: String? = null,
  val message: String? = null,
  val timestamp: Timestamp = Timestamp(System.currentTimeMillis()),
  @Exclude var chatType: ChatType = ChatType.mine,
  @Exclude var senderLabel: String? = userName
) {

  companion object Factory {
    fun fromDocumentSnapshot(ds: DocumentSnapshot) : Chat {
      val id = ds.id
      val userName = ds.getString("userName")
      val message = ds.getString("message")

      return Chat(id, userName, message)
    }
  }
}
