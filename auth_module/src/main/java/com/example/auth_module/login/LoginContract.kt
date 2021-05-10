package com.example.auth_module.login

import android.content.Intent
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult


interface LoginContract {

    interface View {

        fun showErrorMessage(errorMessage: String)

        fun showProgressBar(show: Boolean)

        fun moveToRegPage(intent: Intent)

        fun moveToAccountPage(intent: Intent)

        fun bindingUI()

        fun configurationUI()
    }

    interface Presenter {

        fun onSignUpBtnClicked()

        fun onSignInBtnClicked(email: String, password: String)

        fun signInFailed(message: String)

        fun signInSuccessful()

        fun cancelSignIn()
    }

    interface Model {

         fun signIn(email: String, password: String)

         fun cancelSignInProcess()
    }
}