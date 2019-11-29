package com.example.chatapplication.ui.login

import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chatapplication.R
import com.example.chatapplication.data.AuthRepository
import com.example.chatapplication.data.models.AuthUser
import com.example.chatapplication.data.models.NavEventArgs
import com.example.chatapplication.data.models.validateAuthFields
import com.example.kotlin_starter_app.ui.BaseViewModel
import com.example.todo_app.util.Event
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: AuthRepository) : BaseViewModel() {
  val authUser = AuthUser()

  private val _isUserNameInvalid = MutableLiveData<Boolean>(false)
  val isUserNameInvalid: LiveData<Boolean> get() = _isUserNameInvalid

  private val _isPasswordInvalid = MutableLiveData<Boolean>(false)
  val isPasswordInvalid: LiveData<Boolean> get() = _isPasswordInvalid

  fun goToSignUp() {
    _navigationEvent.value = Event(NavEventArgs(R.id.act_login_to_signup))
  }

  fun goToChat() {
    _navigationEvent.value =
      Event(NavEventArgs(R.id.act_login_to_chat, bundleOf("userName" to authUser.userName)))
  }

  fun login() {
    clearErrors()
    hideKeyboard()

    authUser.validateAuthFields({
      checkIfUserNameAvailable()
    }, {
      _isUserNameInvalid.value = true
    }, {
      _isPasswordInvalid.value = true
    })
  }

  private fun checkIfUserNameAvailable() {
    repository.checkUserNames(authUser.userName).addOnSuccessListener {
      if (it.documents.isNotEmpty()) {
        if (it.documents[0]["password"] == authUser.password) {
          goToChat()
          return@addOnSuccessListener
        }
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

}
