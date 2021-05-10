package com.example.locationtrackerkotlinversion.di.modules

import android.content.Context

import com.example.locationtrackerkotlinversion.MyApplication
import com.example.locationtrackerkotlinversion.Navigation
import com.example.navigation_module.INavigation

import dagger.Binds
import dagger.Module

@Module
abstract class MyApplicationModule {

    @Binds
    abstract fun bindContext(application: MyApplication): Context

    @Binds
    abstract fun bindNavigation(navigation: Navigation): INavigation

}