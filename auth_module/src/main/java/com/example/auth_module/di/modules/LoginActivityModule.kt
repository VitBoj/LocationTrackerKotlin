package com.example.auth_module.di.modules

import com.example.auth_module.login.LoginActivity
import com.example.auth_module.login.LoginContract
import com.example.auth_module.login.LoginPresenter
import com.example.navigation_module.INavigation

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class LoginActivityModule {

    @Binds
    abstract fun provideLoginActivityView(activity: LoginActivity): LoginContract.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideLoginActivityPresenter(loginActivityView: LoginContract.View,
                                          navigation: INavigation
        ): LoginContract.Presenter = LoginPresenter(loginActivityView, navigation)
    }


}