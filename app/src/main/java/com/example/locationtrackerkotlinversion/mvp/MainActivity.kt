package com.example.locationtrackerkotlinversion.mvp

import android.os.Bundle

import com.example.locationtrackerkotlinversion.R
import com.example.navigation_module.INavigation

import dagger.android.support.DaggerAppCompatActivity

import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var navigation: INavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.checkIfUserIsSignedIn()
    }

    override fun moveToLogin() {
        startActivity(navigation.toLogin())
    }

    override fun moveToAccount() {
        startActivity(navigation.toAccount())
    }

}
