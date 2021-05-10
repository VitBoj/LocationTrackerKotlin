package com.example.auth_module.registration

import android.content.Context

import com.example.auth_module.R
import com.example.firebase_module.interfaces.IFirebaseRegistration

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

import javax.inject.Inject

class RegistrationModel @Inject constructor(private val presenter: RegistrationContract.Presenter)
    : RegistrationContract.Model {

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var firebaseRegistration: IFirebaseRegistration

    private lateinit var signUpJob: Job

    override fun signUp(email: String, password: String, userName: String) {
        signUpJob = GlobalScope.launch(Dispatchers.IO) {
            firebaseRegistration.addNewUser(email, password)
                    .addOnCompleteListener { addNewUser ->
                        if (addNewUser.isSuccessful) {
                            firebaseRegistration.saveNewUserToDB(userName, email)
                                    .addOnCompleteListener { saveNewUserToDB ->
                                        if (saveNewUserToDB.isSuccessful) {
                                            presenter.signUpSuccessful()
                                        } else {
                                            presenter.signUpFailed(context.getString(R.string.please_try_again))
                                        }
                                    }
                        } else {
                            presenter.signUpFailed(firebaseRegistration.getErrorMessage(addNewUser))
                        }
                    }
        }
    }

    override fun cancelSignUpProcess() {
        signUpJob.cancel()
    }

}