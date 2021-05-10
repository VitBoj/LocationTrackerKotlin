package com.example.location_module

import android.content.Context

import androidx.work.Worker
import androidx.work.WorkerParameters

import com.example.location_module.interfaces.IMyLocationsManager
import com.example.location_module.interfaces.ISaveLocationManager
import com.example.location_module.interfaces.IWorkerFactory

import com.orhanobut.hawk.Hawk

import javax.inject.Inject
import javax.inject.Provider

class SaveLocationWorker(val context: Context, workerParams: WorkerParameters,
                         private val saveLocationManager: ISaveLocationManager,
                         private val myLocationsManager: IMyLocationsManager)
    : Worker(context, workerParams) {

    private fun init() {
        myLocationsManager.initLocationManager()
        Hawk.init(context).build()
    }

    override fun doWork(): Result {
        init()
        if (Hawk.count() > 0) {
            for (i in 0 until Hawk.count()) {
                val location = Hawk.get<LocationModel>(i.toString())
                if (location != null) {
                    saveLocationManager.saveLocationToFirebaseDB(location)
                }
            }
            Hawk.deleteAll()
        }
        return Result.success()
    }

    class Factory @Inject constructor(
            private val context: Provider<Context>,
            private val saveLocationManager: Provider<SaveLocationManager>,
            private val myLocationsManager: Provider<MyLocationsManager>
    ) : IWorkerFactory<SaveLocationWorker> {
        override fun create(params: WorkerParameters): SaveLocationWorker {
            return SaveLocationWorker(context.get(),
                    params,
                    saveLocationManager.get(),
                    myLocationsManager.get())
        }
    }

}