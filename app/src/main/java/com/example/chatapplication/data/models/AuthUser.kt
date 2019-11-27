package com.example.chatapplication.data.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class AuthUser : BaseObservable() {
  @get: Bindable
  var userName: String = ""

  @get: Bindable
  var password: String = ""
}