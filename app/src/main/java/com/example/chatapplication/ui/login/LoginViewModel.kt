package com.example.chatapplication.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapplication.data.AuthRepository
import com.example.chatapplication.data.models.AuthUser
import com.example.todo_app.util.Event
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {
  val authUser = AuthUser()

  private val _isUserNameInvalid = MutableLiveData<Boolean>(false)
  val isUserNameInvalid: LiveData<Boolean> get() = _isUserNameInvalid

  private val _isPasswordInvalid = MutableLiveData<Boolean>(false)
  val isPasswordInvalid: LiveData<Boolean> get() = _isPasswordInvalid

  private val _signUpEvent = MutableLiveData<Event<Unit>>()
  val signUpEvent: LiveData<Event<Unit>> = _signUpEvent

  fun goToSignUp() {
    _signUpEvent.value = Event(Unit)
  }

  fun login() {
    clearErrors()
    if (isFormValid()) {
      checkIfUserNameAvailable()
    }
  }

  private fun checkIfUserNameAvailable() {
    repository.checkUserNames(authUser.userName).addOnSuccessListener {
      if (it.documents.isNotEmpty()) {
//        addUserToDatabase()
        return@addOnSuccessListener
      }
      Log.d("ViewModel", "Username is already used!")
      showErrors()
    }.addOnFailureListener {
      Log.d("ViewModel", "Query Failed!")
      showErrors()
    }
  }


  private fun showErrors() {
    _isUserNameInvalid.value = true
    _isPasswordInvalid.value = true
  }

  private fun clearErrors() {
    _isUserNameInvalid.value = false
    _isPasswordInvalid.value = false
  }

  private fun isFormValid(): Boolean {
    val userNameValid = validateUserName()
    val passwordValid = validatePassword()
    return userNameValid && passwordValid
  }

  private fun validateUserName(): Boolean {
    if (authUser.userName.isEmpty()) {
      _isUserNameInvalid.value = true
      return false
    }
    return true
  }

  private fun validatePassword(): Boolean {
    if (authUser.password.isEmpty()) {
      _isPasswordInvalid.value = true
      return false
    }
    return true
  }
}
