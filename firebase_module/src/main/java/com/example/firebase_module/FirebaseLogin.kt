package com.example.firebase_module

import android.content.Context

import com.example.firebase_module.interfaces.IFirebaseLogin
import com.example.firebase_module.interfaces.IFirebaseFormatter
import com.example.firebase_module.interfaces.IFirebaseHelper

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

import javax.inject.Inject

class FirebaseLogin @Inject constructor(val context: Context,
                                        private val firebaseFormatter: IFirebaseFormatter,
                                        val firebaseHelper: IFirebaseHelper)
    : IFirebaseLogin {

    override fun userSignIn(email: String, password: String): Task<AuthResult> {
        return firebaseHelper.authInstance(context)
                .signInWithEmailAndPassword(email, password)
    }

    override fun getErrorMessage(result: Task<AuthResult>): String {
        return firebaseFormatter.convertAuthResultToErrorMessage(result)
    }

}

