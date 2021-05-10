package com.example.locationtrackerkotlinversion.di.modules

import com.example.account_module.di.AccountModule
import com.example.account_module.di.SwitchButtonStateModule
import com.example.account_module.mvp.AccountActivity
import com.example.auth_module.di.ActivityScope
import com.example.auth_module.di.modules.LoginActivityModule
import com.example.auth_module.di.modules.RegistrationActivityModule
import com.example.auth_module.login.LoginActivity
import com.example.auth_module.registration.RegistrationActivity
import com.example.firebase_module.di.FirebaseLoginModule
import com.example.firebase_module.di.FirebaseRegistrationModule
import com.example.location_module.di.modules.WorkManagerSetUpModule
import com.example.locationtrackerkotlinversion.mvp.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [RegistrationActivityModule::class, FirebaseRegistrationModule::class])
    abstract fun bindRegistrationActivity(): RegistrationActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginActivityModule::class, FirebaseLoginModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [AccountModule::class, WorkManagerSetUpModule::class,SwitchButtonStateModule::class])
    abstract fun bindAccountActivity(): AccountActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}