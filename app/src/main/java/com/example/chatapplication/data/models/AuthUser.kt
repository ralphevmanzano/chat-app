package com.example.chatapplication.data.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class AuthUser : BaseObservable() {
  @get: Bindable
  var userName: String = ""

  @get: Bindable
  var password: String = ""
}

fun AuthUser.validateAuthFields(
  onValid: () -> Unit,
  onUserNameInvalid: () -> Unit,
  onPasswordInvalid: () -> Unit
) {
  val isUserNameValid = this.userName.isNotEmptyAndHasValidLength()
  val isPasswordValid = this.password.isNotEmptyAndHasValidLength()

  if (isUserNameValid && isPasswordValid) {
    onValid()
  } else {
    if (!isUserNameValid) onUserNameInvalid()
    if (!isPasswordValid) onPasswordInvalid()
  }
}

fun String.isNotEmptyAndHasValidLength(): Boolean {
  return this.isNotEmpty() && (this.length in 8..16)
}