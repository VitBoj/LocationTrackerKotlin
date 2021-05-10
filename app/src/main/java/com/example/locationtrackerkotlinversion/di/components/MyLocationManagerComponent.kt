package com.example.locationtrackerkotlinversion.di.components

import com.example.location_module.MyLocationsManager
import com.example.location_module.di.modules.SaveLocationManagerModule

import dagger.Component

@Component(modules = [SaveLocationManagerModule::class])
interface MyLocationManagerComponent {
    fun inject(myLocationsManager: MyLocationsManager)
}