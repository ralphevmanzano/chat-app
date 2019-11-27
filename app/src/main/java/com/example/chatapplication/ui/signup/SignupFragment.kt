package com.example.chatapplication.ui.signup

import android.graphics.Paint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

import com.example.chatapplication.R
import com.example.chatapplication.databinding.SignupFragmentBinding
import com.example.kotlin_starter_app.ui.BaseFragment
import com.example.todo_app.util.EventObserver
import kotlinx.android.synthetic.main.signup_fragment.*

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

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel.loginEvent.observe(viewLifecycleOwner, EventObserver {
      navigateTo(R.id.act_signup_to_login)
    })
  }

}
