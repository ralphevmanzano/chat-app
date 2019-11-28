package com.example.chatapplication.ui.signup

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import com.example.chatapplication.R
import com.example.chatapplication.databinding.SignupFragmentBinding
import com.example.kotlin_starter_app.ui.BaseFragment
import com.example.todo_app.util.EventObserver

class SignupFragment : BaseFragment<SignupViewModel, SignupFragmentBinding>() {

  override fun getViewModel(): Class<SignupViewModel> {
    return SignupViewModel::class.java
  }

  override fun getLayoutRes(): Int {
    return R.layout.signup_fragment
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
    binding.txtLogin.paintFlags = Paint.UNDERLINE_TEXT_FLAG
  }

  override fun observeNavigationEvents() {
    viewModel.navigationEvent.observe(viewLifecycleOwner, EventObserver { navEventArgs ->
      navigateTo(navEventArgs)
    })
  }

}
