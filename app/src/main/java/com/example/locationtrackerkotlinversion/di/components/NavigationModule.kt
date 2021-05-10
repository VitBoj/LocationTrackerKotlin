package com.example.locationtrackerkotlinversion.di.components

import android.content.Context

import com.example.locationtrackerkotlinversion.Navigation
import com.example.navigation_module.INavigation

import dagger.Module
import dagger.Provides

@Module
class NavigationModule {
    @Provides
    fun provideNavigation(context: Context):INavigation = Navigation(context)
}