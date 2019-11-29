package com.example.chatapplication.util

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.chatapplication.data.models.Chat

class ChatsDiffCallBack : DiffUtil.ItemCallback<Chat>() {
  override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
//    Log.d("Adapter", "Old: ${oldItem.id} New: ${newItem.id}")
//    Log.d("Adapter", "Equal: ${oldItem.id == newItem.id}")

    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
    return oldItem == newItem
  }
}