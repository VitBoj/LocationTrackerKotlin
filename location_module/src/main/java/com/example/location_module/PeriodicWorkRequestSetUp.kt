package com.example.location_module

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder

import com.example.location_module.interfaces.IPeriodicWorkRequestSetUp

import java.util.concurrent.TimeUnit

import javax.inject.Inject

class PeriodicWorkRequestSetUp @Inject constructor() : IPeriodicWorkRequestSetUp {
    companion object {
        private const val REPEAT_INTERVAL: Long = 15
    }

    private val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

    override fun setPeriodicWorkRequest(): PeriodicWorkRequest {
        return PeriodicWorkRequestBuilder<SaveLocationWorker>(REPEAT_INTERVAL, TimeUnit.MINUTES)
                .setConstraints(constraints).build()
    }


}