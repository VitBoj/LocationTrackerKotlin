package com.example.auth_module.di.modules

import com.example.auth_module.registration.RegistrationActivity
import com.example.auth_module.registration.RegistrationContract
import com.example.auth_module.registration.RegistrationPresenter
import com.example.navigation_module.INavigation

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RegistrationActivityModule {

    @Binds
    abstract fun provideRegistrationActivityView(activity: RegistrationActivity): RegistrationContract.View

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideRegistrationActivityPresenter(registrationActivityView: RegistrationContract.View,
                                                 navigation: INavigation
        ): RegistrationContract.Presenter = RegistrationPresenter(registrationActivityView,navigation)
    }
}