package com.example.locationtrackerkotlinversion.mvp

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class MainPresenter @Inject constructor(private val view: MainContract.View)
    : MainContract.Presenter {

    override fun checkIfUserIsSignedIn() {
        val user = FirebaseAuth.getInstance().currentUser
        if(user != null){
            view.moveToAccount()
        }else{
            view.moveToLogin()
        }
    }

}