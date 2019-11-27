package com.example.chatapplication.data

import android.util.Log
import com.example.chatapplication.data.models.AuthUser
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class AuthRepository @Inject constructor() {

  val ref = FirebaseFirestore.getInstance().collection("users")

  fun signup(authUser: AuthUser): Task<DocumentReference> {
    val user = HashMap<String, Any>()
    user["userName"] = authUser.userName
    user["password"] = authUser.password
    return ref.add(user)
  }

  fun checkUserNames(userName: String) : Task<QuerySnapshot> {
    return ref.whereEqualTo("userName", userName).get()
  }
}