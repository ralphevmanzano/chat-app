package com.example.chatapplication.ui.auth

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController

import com.example.chatapplication.R
import com.example.chatapplication.databinding.AuthFragmentBinding
import com.example.chatapplication.ui.MainActivity
import com.example.kotlin_starter_app.ui.BaseFragment
import com.example.todo_app.util.EventObserver

class AuthFragment : BaseFragment<AuthViewModel, AuthFragmentBinding>() {

  override fun getViewModel(): Class<AuthViewModel> {
    return AuthViewModel::class.java
  }

  override fun getLayoutRes(): Int {
    return R.layout.auth_fragment
  }

  override fun onResume() {
    super.onResume()
    showToolbar(false)
    showLogOutButton(false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    viewModel.signupEvent.observe(viewLifecycleOwner, EventObserver {
      navigateTo(R.id.act_auth_to_signup)
    })

    viewModel.loginEvent.observe(viewLifecycleOwner, EventObserver {
      navigateTo(R.id.act_auth_to_login)
    })

  }
}
