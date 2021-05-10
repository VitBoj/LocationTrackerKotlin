package com.example.auth_module.registration

import android.content.Intent
import android.os.Bundle
import android.view.View

import com.example.auth_module.databinding.ActivityRegistrationBinding

import dagger.android.support.DaggerAppCompatActivity

import javax.inject.Inject

class RegistrationActivity : DaggerAppCompatActivity(), RegistrationContract.View {

    @Inject
    lateinit var presenter: RegistrationPresenter

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUI()
        configurationUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.cancelSignUp()
    }

    override fun bindingUI() {
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun configurationUI() {
        binding.signUpBtn.setOnClickListener {
            val email = binding.emailField.text.toString()
            val password = binding.passwordField.text.toString()
            val userName = binding.userNameField.text.toString()
            presenter.onSignUpBtnClicked(email, password, userName)
        }
    }

    override fun showErrorMessage(errorMessage: String) {
        binding.failedMessage.text = errorMessage
    }

    override fun showProgressBar(show: Boolean) {
        if (show) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    override fun moveToAccountPage(intent: Intent) {
        startActivity(intent)
    }


}