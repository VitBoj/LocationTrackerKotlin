package com.example.locationtrackerkotlinversion

import androidx.work.Configuration
import androidx.work.WorkManager

import com.example.location_module.DaggerWorkerFactory
import com.example.locationtrackerkotlinversion.di.components.DaggerMyApplicationComponent

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

import javax.inject.Inject

class MyApplication : DaggerApplication() {

    @Inject
    lateinit var daggerWorkerFactory: DaggerWorkerFactory

    override fun onCreate() {
        super.onCreate()
        configureWorkManager()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerMyApplicationComponent.builder()
                .application(this)
                .build()
        appComponent.inject(this)
        return appComponent
    }

    private fun configureWorkManager() {
        val config = Configuration.Builder()
                .setWorkerFactory(daggerWorkerFactory)
                .build()
        WorkManager.initialize(this, config)
    }

}