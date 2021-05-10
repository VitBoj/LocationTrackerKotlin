package com.example.locationtrackerkotlinversion

import android.content.Context
import android.content.Intent

import com.example.account_module.mvp.AccountActivity
import com.example.auth_module.login.LoginActivity
import com.example.auth_module.registration.RegistrationActivity
import com.example.navigation_module.INavigation

import javax.inject.Inject

class Navigation @Inject constructor(private val context: Context): INavigation {

    override fun toLogin():Intent {
        return Intent(context, LoginActivity::class.java)
    }

    override fun toRegistration():Intent {
        return Intent(context, RegistrationActivity::class.java)
    }

    override fun toAccount():Intent {
        return Intent(context,AccountActivity::class.java)
    }

}