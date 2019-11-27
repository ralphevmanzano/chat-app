package com.example.chatapplication.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_starter_app.ui.BaseViewModel
import com.example.todo_app.util.Event
import javax.inject.Inject

class AuthViewModel @Inject constructor() : BaseViewModel() {

  private val _loginEvent = MutableLiveData<Event<Unit>>()
  val loginEvent: LiveData<Event<Unit>> = _loginEvent

  private val _signupEvent = MutableLiveData<Event<Unit>>()
  val signupEvent: LiveData<Event<Unit>> = _signupEvent

  fun goToLogin() {
    _loginEvent.value = Event(Unit)
  }

  fun goToSignup() {
    _signupEvent.value = Event(Unit)
  }
}
