package com.example.auth_module.login

import android.content.Intent
import android.os.Build
import android.os.Bundle

import androidx.annotation.RequiresApi
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

import com.example.auth_module.databinding.ActivityLoginBinding

import dagger.android.support.DaggerAppCompatActivity

import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginPresenter

    private lateinit var binding: ActivityLoginBinding

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUI()
        configurationUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.cancelSignIn()
    }

    override fun bindingUI() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun configurationUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            presenter.openPermissionsSettings(this)
        }
        this.binding.signInBtn.setOnClickListener {
            val email = binding.emailField.text.toString()
            val password = binding.passwordField.text.toString()
            presenter.onSignInBtnClicked(email, password)
        }
        this.binding.signUpBtn.setOnClickListener { presenter.onSignUpBtnClicked() }
    }

    override fun showErrorMessage(errorMessage: String) {
        binding.failedMessage.text = errorMessage
    }

    override fun showProgressBar(show: Boolean) {
        if (show) {
            binding.progressBar.isVisible
        } else {
            binding.progressBar.isInvisible
        }
    }

    override fun moveToRegPage(intent: Intent) {
        startActivity(intent)
    }

    override fun moveToAccountPage(intent: Intent) {
        startActivity(intent)
    }

}