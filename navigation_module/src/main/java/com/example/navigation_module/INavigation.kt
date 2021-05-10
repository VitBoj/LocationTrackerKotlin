package com.example.navigation_module

import android.content.Intent

interface INavigation {

    fun toLogin(): Intent

    fun toAccount(): Intent

    fun toRegistration(): Intent

}