package com.example.chatapplication.data.models

import java.sql.Timestamp

enum class ChatType { mine, theirs }
data class Chat(
  val userName: String? = null,
  val message: String? = null,
  var chatType: ChatType = ChatType.mine
)