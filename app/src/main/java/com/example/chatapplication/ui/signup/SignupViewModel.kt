package com.example.chatapplication.ui.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatapplication.data.AuthRepository
import com.example.chatapplication.data.models.AuthUser
import com.example.todo_app.util.Event
import javax.inject.Inject

class SignupViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

  val authUser = AuthUser()

  private val _isUserNameInvalid = MutableLiveData<Boolean>(false)
  val isUserNameInvalid: LiveData<Boolean> get() = _isUserNameInvalid

  private val _isPasswordInvalid = MutableLiveData<Boolean>(false)
  val isPasswordInvalid: LiveData<Boolean> get() = _isPasswordInvalid

  private val _loginEvent = MutableLiveData<Event<Unit>>()
  val loginEvent: LiveData<Event<Unit>> = _loginEvent

  fun goToLogin() {
    _loginEvent.value = Event(Unit)
  }

  fun signUp() {
    clearErrors()
    if (isFormValid()) {
      checkIfUserNameAvailable()
    }
  }

  private fun checkIfUserNameAvailable() {
    repository.checkUserNames(authUser.userName).addOnSuccessListener {
      if (it.documents.isEmpty()) {
        addUserToDatabase()
        return@addOnSuccessListener
      }
      Log.d("ViewModel", "Username is already used!")
      showErrors()
    }.addOnFailureListener {
      Log.d("ViewModel", "Query Failed!")
      showErrors()
    }
  }

  private fun addUserToDatabase() {
    repository.signup(authUser).addOnSuccessListener {
      Log.d("ViewModel", "User added!")
    }.addOnFailureListener {
      Log.d("ViewModel", "Add Failed!")
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
