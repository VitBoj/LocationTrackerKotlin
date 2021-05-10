package com.example.location_module.di.modules

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

import com.example.location_module.MyLocationsManager
import com.example.location_module.SaveLocationManager
import com.example.location_module.SaveLocationWorker

import dagger.Module
import dagger.Provides

@Module
class SaveLocationWorkerModule {
    @Provides
    fun provideSaveLocationWorker(context: Context, workerParameters: WorkerParameters,
                                  saveLocationManager: SaveLocationManager,
                                  myLocationsManager: MyLocationsManager)
            : Worker = SaveLocationWorker(context, workerParameters, saveLocationManager, myLocationsManager)

}