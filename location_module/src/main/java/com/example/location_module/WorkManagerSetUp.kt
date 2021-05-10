package com.example.location_module

import androidx.work.WorkManager

import com.example.location_module.interfaces.IPeriodicWorkRequestSetUp
import com.example.location_module.interfaces.IWorkManagerSetUp

import javax.inject.Inject

class WorkManagerSetUp @Inject constructor(private val periodicWorkRequestSetUp: IPeriodicWorkRequestSetUp)
    : IWorkManagerSetUp {

    override fun setUpWorkManager() {
        WorkManager.getInstance()
                .enqueue(periodicWorkRequestSetUp.setPeriodicWorkRequest())
    }

    override fun cancelAllWorks() {
        WorkManager.getInstance().cancelAllWork()
    }

}