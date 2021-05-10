package com.example.auth_module.login

import android.Manifest.*
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build

import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat

import com.example.auth_module.R
import com.example.navigation_module.INavigation

import javax.inject.Inject

class LoginPresenter @Inject constructor(private val view: LoginContract.View,
                                         private val navigation: INavigation)
    : LoginContract.Presenter {

    companion object {
        private const val REQUEST_CODE = 101
    }

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var model: LoginModel

    override fun onSignUpBtnClicked() {
        view.moveToRegPage(navigation.toRegistration())
    }

    override fun onSignInBtnClicked(email: String, password: String) {
        view.showProgressBar(true)
        if (email.isNotEmpty() && password.isNotEmpty()) {
            model.signIn(email, password)
        } else {
            signInFailed(context.getString(R.string.empty_fields))
        }
    }

    override fun signInFailed(message: String) {
        view.showErrorMessage(message)
        view.showProgressBar(false)
    }

    override fun signInSuccessful() {
        view.showProgressBar(false)
        view.moveToAccountPage(navigation.toAccount())
    }

    override fun cancelSignIn() {
        model.cancelSignInProcess()
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun openPermissionsSettings(activity: LoginActivity) {
        val foreground = ActivityCompat.checkSelfPermission(
                activity,
                permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        if (foreground) {
            val background = ActivityCompat.checkSelfPermission(
                    activity,
                    permission.ACCESS_BACKGROUND_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
            if (background) {
            } else {
                ActivityCompat.requestPermissions(
                        activity,
                        arrayOf(permission.ACCESS_BACKGROUND_LOCATION),
                        REQUEST_CODE
                )
            }
        } else {
            ActivityCompat.requestPermissions(
                    activity, arrayOf(
                    permission.ACCESS_FINE_LOCATION,
                    permission.ACCESS_BACKGROUND_LOCATION
            ), REQUEST_CODE
            )
        }
    }

}