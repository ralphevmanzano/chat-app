package com.example.chatapplication.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.data.models.Chat
import com.example.chatapplication.ui.chat.ChatAdapter

@BindingAdapter("app:chats")
fun setChats(listView: RecyclerView, items: List<Chat>) {
  (listView.adapter as ChatAdapter).submitList(items)
}