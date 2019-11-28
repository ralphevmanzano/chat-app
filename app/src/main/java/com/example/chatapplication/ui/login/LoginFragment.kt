package com.example.chatapplication.ui.login

import android.graphics.Paint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.chatapplication.R
import com.example.chatapplication.databinding.LoginFragmentBinding
import com.example.kotlin_starter_app.ui.BaseFragment
import com.example.todo_app.util.EventObserver

class LoginFragment : BaseFragment<LoginViewModel, LoginFragmentBinding>() {

  override fun getViewModel(): Class<LoginViewModel> {
    return LoginViewModel::class.java
  }

  override fun getLayoutRes(): Int {
    return R.layout.login_fragment
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    showToolbar(true)
    showLogOutButton(false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initUI()
  }

  private fun initUI() {
    binding.txtSignup.paintFlags = Paint.UNDERLINE_TEXT_FLAG
  }

  override fun observeNavigationEvents() {
    viewModel.navigationEvent.observe(viewLifecycleOwner, EventObserver { navEventArgs ->
      navigateTo(navEventArgs)
    })
  }
}
