package com.example.chatapplication.ui.chat

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

import com.example.chatapplication.R
import com.example.chatapplication.data.models.Chat
import com.example.chatapplication.databinding.ChatFragmentBinding
import com.example.kotlin_starter_app.ui.BaseFragment
import kotlinx.android.synthetic.main.chat_fragment.*

class ChatFragment : BaseFragment<ChatViewModel, ChatFragmentBinding>() {

  override fun getViewModel(): Class<ChatViewModel> {
    return ChatViewModel::class.java
  }

  override fun getLayoutRes(): Int {
    return R.layout.chat_fragment
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    showLogOutButton(true)
    viewModel.setup(arguments?.getString("userName"))
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    initRecyclerView()
  }

  private fun initRecyclerView() {
    val adapter = ChatAdapter()
    binding.rv.adapter = adapter

    adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
      override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
        rv.scrollToPosition(adapter.itemCount - 1)
      }
    })

    viewModel.chats.observe(viewLifecycleOwner, Observer {
      adapter.submitList(it)
    })
  }

}
