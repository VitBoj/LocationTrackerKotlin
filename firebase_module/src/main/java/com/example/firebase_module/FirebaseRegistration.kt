package com.example.firebase_module

import android.content.Context

import com.example.firebase_module.interfaces.IFirebaseRegistration
import com.example.firebase_module.interfaces.IFirebaseFormatter
import com.example.firebase_module.interfaces.IFirebaseHelper

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

import javax.inject.Inject

class FirebaseRegistration @Inject constructor(val context: Context,
                                               private val firebaseFormatter: IFirebaseFormatter,
                                               val firebaseHelper: IFirebaseHelper)
    : IFirebaseRegistration {

    companion object {
        private const val DB_USER_TABLE_NAME = "Users"
    }

    override fun addNewUser(email: String, password: String): Task<AuthResult> {
        return firebaseHelper.authInstance(context)
                .createUserWithEmailAndPassword(email, password)
    }

    override fun saveNewUserToDB(userName: String, email: String): Task<Void> {
        val userId = firebaseHelper.getCurrentUser(context).uid
        val user = UserModel(userName, email, userId)
        return firebaseHelper.getDBReferences(DB_USER_TABLE_NAME, userId).setValue(user)
    }

    override fun getErrorMessage(result: Task<AuthResult>): String {
        return firebaseFormatter.convertAuthResultToErrorMessage(result)
    }

}