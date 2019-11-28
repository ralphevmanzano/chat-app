package com.example.chatapplication.ui.auth

import com.example.chatapplication.R
import com.example.chatapplication.data.models.NavEventArgs
import com.example.kotlin_starter_app.ui.BaseViewModel
import com.example.todo_app.util.Event
import javax.inject.Inject

class AuthViewModel @Inject constructor() : BaseViewModel() {

  fun goToLogin() {
    _navigationEvent.value = Event(NavEventArgs(R.id.act_auth_to_login))
  }

  fun goToSignup() {
    _navigationEvent.value = Event(NavEventArgs(R.id.act_auth_to_signup))
  }
}
