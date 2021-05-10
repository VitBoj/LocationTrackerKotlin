package com.example.auth_module.registration

import android.content.Intent

interface RegistrationContract {

    interface View {

        fun showErrorMessage(errorMessage: String)

        fun showProgressBar(show: Boolean)

        fun bindingUI()

        fun configurationUI()

        fun moveToAccountPage(intent: Intent)
    }

    interface Presenter {

        fun onSignUpBtnClicked(email: String, password: String, userName: String)

        fun signUpFailed(message: String)

        fun signUpSuccessful()

        fun cancelSignUp()
    }

    interface Model {

        fun signUp(email: String, password: String, userName: String)

        fun cancelSignUpProcess()

    }

}