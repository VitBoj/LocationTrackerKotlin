package com.example.firebase_module

import com.example.firebase_module.interfaces.IFirebaseFormatter

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

import javax.inject.Inject

class FirebaseFormatter @Inject constructor() : IFirebaseFormatter {

    override fun convertAuthResultToErrorMessage(result: Task<AuthResult>): String {
        val exception = result.exception.toString()
        return (exception.split(':')[1]).drop(1)
    }

}