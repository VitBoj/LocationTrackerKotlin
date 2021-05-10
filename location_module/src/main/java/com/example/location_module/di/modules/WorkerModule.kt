package com.example.location_module.di.modules

import androidx.work.ListenableWorker

import com.example.location_module.interfaces.IWorkerFactory
import com.example.location_module.SaveLocationWorker
import com.example.location_module.di.WorkerKey

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {
    @Binds
    @IntoMap
    @WorkerKey(SaveLocationWorker::class)
    fun bindHelloWorker(factory: SaveLocationWorker.Factory): IWorkerFactory<out ListenableWorker>
}