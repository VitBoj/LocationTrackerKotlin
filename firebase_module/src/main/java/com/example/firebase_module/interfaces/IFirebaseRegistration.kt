package com.example.firebase_module.interfaces

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface IFirebaseRegistration {

    fun addNewUser(email: String, password: String): Task<AuthResult>

    fun saveNewUserToDB(userName: String, email: String): Task<Void>

    fun getErrorMessage(result: Task<AuthResult>): String

}