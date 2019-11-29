package com.example.kotlin_starter_app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapplication.data.models.NavEventArgs
import com.example.todo_app.util.Event

open class BaseViewModel : ViewModel() {

  protected val _hideKeyboardEvent = MutableLiveData<Event<Unit>>()
  val hideKeyboardEvent: LiveData<Event<Unit>> = _hideKeyboardEvent

  protected val _snackbarEvent = MutableLiveData<Event<String>>()
  val snackbarEvent: LiveData<Event<String>> = _snackbarEvent

  protected val _navigationEvent = MutableLiveData<Event<NavEventArgs>>()
  val navigationEvent: LiveData<Event<NavEventArgs>> = _navigationEvent

  protected fun hideKeyboard() {
    _hideKeyboardEvent.value = Event(Unit)
  }
}