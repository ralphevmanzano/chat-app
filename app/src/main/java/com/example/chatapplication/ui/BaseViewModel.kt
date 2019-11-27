package com.example.kotlin_starter_app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_app.util.Event

open class BaseViewModel : ViewModel() {

  // TODO: put common observables here in your viewmodels

  protected val _snackbarText = MutableLiveData<Event<String>>()
  val snackbarText: LiveData<Event<String>> = _snackbarText

}