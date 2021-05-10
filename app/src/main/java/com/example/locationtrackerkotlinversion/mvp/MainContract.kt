package com.example.locationtrackerkotlinversion.mvp

interface MainContract {

    interface View {

        fun moveToLogin()

        fun moveToAccount()
    }

    interface Presenter {

        fun checkIfUserIsSignedIn()

    }
}