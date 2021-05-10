package com.example.auth_module.registration

import android.content.Context
import com.example.auth_module.R
import com.example.navigation_module.INavigation
import javax.inject.Inject


class RegistrationPresenter @Inject constructor(private val view: RegistrationContract.View,private val navigation: INavigation) :
        RegistrationContract.Presenter {


    @Inject
    lateinit var context: Context

    @Inject
    lateinit var model: RegistrationModel


    override fun onSignUpBtnClicked(email: String, password: String, userName: String) {
        view.showProgressBar(true)
        if (email.isNotEmpty() && password.isNotEmpty()) {
            model.signUp(email, password, userName)
        } else {
            signUpFailed(context.getString(R.string.empty_fields))
        }
    }

    override fun signUpFailed(message: String) {
        view.showErrorMessage(message)
        view.showProgressBar(false)
    }

    override fun signUpSuccessful() {
        view.moveToAccountPage(navigation.toAccount())
        view.showProgressBar(false)
    }

    override fun cancelSignUp() {
        model.cancelSignUpProcess()
    }
}