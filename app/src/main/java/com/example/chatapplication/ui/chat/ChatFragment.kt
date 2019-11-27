package com.example.chatapplication.ui.chat

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
    showLogOutButton(false)

  }


}
