package com.example.location_module.di.modules

import com.example.location_module.PeriodicWorkRequestSetUp
import com.example.location_module.WorkManagerSetUp
import com.example.location_module.interfaces.IWorkManagerSetUp

import dagger.Module
import dagger.Provides

@Module
class WorkManagerSetUpModule {
    @Provides
    fun provideWorkManagerSetup(periodicWorkRequestSetUp: PeriodicWorkRequestSetUp)
            : IWorkManagerSetUp = WorkManagerSetUp(periodicWorkRequestSetUp)
}