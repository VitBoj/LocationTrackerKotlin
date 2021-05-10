package com.example.location_module.interfaces

import androidx.work.PeriodicWorkRequest

interface IPeriodicWorkRequestSetUp {
    fun setPeriodicWorkRequest(): PeriodicWorkRequest
}