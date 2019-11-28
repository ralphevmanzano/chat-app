package com.example.chatapplication.ui.chat

import android.os.Bundle
import android.view.View

import com.example.chatapplication.R
import com.example.chatapplication.databinding.ChatFragmentBinding
import com.example.kotlin_starter_app.ui.BaseFragment

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
  }

}
