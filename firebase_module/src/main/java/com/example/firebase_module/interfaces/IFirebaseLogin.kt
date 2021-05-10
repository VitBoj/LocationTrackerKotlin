package com.example.firebase_module.interfaces

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface IFirebaseLogin {

    fun userSignIn(email: String, password: String): Task<AuthResult>

    fun getErrorMessage(result: Task<AuthResult>): String

}