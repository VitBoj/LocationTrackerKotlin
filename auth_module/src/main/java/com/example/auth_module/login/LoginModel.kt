package com.example.auth_module.login

import com.example.firebase_module.interfaces.IFirebaseLogin
import kotlinx.coroutines.*

import javax.inject.Inject

class LoginModel @Inject constructor(private val presenter: LoginContract.Presenter)
    : LoginContract.Model{

    @Inject
    lateinit var firebaseLogin: IFirebaseLogin

    private lateinit var signInJob:Job

    override  fun signIn(email: String, password: String) {
         signInJob = GlobalScope.launch(Dispatchers.IO) {
            firebaseLogin.userSignIn(email, password)
                    .addOnCompleteListener { userSignIn->
                        if (userSignIn.isSuccessful) {
                            presenter.signInSuccessful()
                        } else {
                            presenter.signInFailed(firebaseLogin.getErrorMessage(userSignIn))
                        }
                    }
        }
    }

    override fun cancelSignInProcess(){
        signInJob.cancel()
    }

}





