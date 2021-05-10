package com.example.locationtrackerkotlinversion.di.components

import com.example.location_module.SaveLocationWorker
import com.example.location_module.di.modules.MyLocationsManagerModule
import com.example.location_module.di.modules.SaveLocationManagerModule

import dagger.Component

@Component(modules = [MyLocationsManagerModule::class, SaveLocationManagerModule::class])
interface SaveLocationsWorkerComponent {
    fun inject(saveLocationWorker: SaveLocationWorker)
}