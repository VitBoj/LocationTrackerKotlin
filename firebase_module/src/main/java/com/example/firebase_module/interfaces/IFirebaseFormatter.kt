package com.example.firebase_module.interfaces

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface IFirebaseFormatter {
    fun convertAuthResultToErrorMessage(result: Task<AuthResult>): String
}