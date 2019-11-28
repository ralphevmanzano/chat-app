package com.example.chatapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapplication.R
import com.example.chatapplication.data.models.NavEventArgs
import com.example.todo_app.util.Event

class MainViewModel: ViewModel() {

  private val _logOutEvent = MutableLiveData<Event<NavEventArgs>>()
  val logOutEvent: LiveData<Event<NavEventArgs>> = _logOutEvent

  fun logOut() {
    _logOutEvent.value = Event(NavEventArgs(R.id.act_chat_to_auth))
  }

}