package com.example.location_module.interfaces

import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

interface IWorkerFactory<T : ListenableWorker> {
    fun create(params: WorkerParameters): T
}