package com.example.chatapplication.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.R
import com.example.chatapplication.data.models.Chat
import com.example.chatapplication.data.models.ChatType
import com.example.chatapplication.databinding.MyChatItemBinding
import com.example.chatapplication.databinding.TheirChatItemBinding

class ChatAdapter : ListAdapter<Chat, ViewHolder>(ChatsDiffCallBack()) {

  class ChatsDiffCallBack : DiffUtil.ItemCallback<Chat>() {
    override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
      return oldItem.userName == oldItem.userName
    }

    override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
      return oldItem == newItem
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder.from(parent, viewType)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  override fun getItemViewType(position: Int): Int {
    if (getItem(position).chatType == ChatType.mine) return R.layout.my_chat_item
    return R.layout.their_chat_item
  }
}

class ViewHolder private constructor(val binding: ViewDataBinding) :
  RecyclerView.ViewHolder(binding.root) {
  
  companion object {
    fun from(parent: ViewGroup, layoutId: Int) : ViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
      val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, layoutId, parent, false)

      return ViewHolder(binding)
    }
  }

  fun bind(chat: Chat) {
    when(binding) {
      is MyChatItemBinding -> binding.chat = chat
      is TheirChatItemBinding -> binding.chat = chat
    }
    binding.executePendingBindings()
  }
  
}