package com.example.location_module.di.modules

import android.content.Context

import com.example.location_module.MyLocationsManager
import com.example.location_module.SaveLocationManager
import com.example.location_module.interfaces.IMyLocationsManager

import dagger.Module
import dagger.Provides

@Module
class MyLocationsManagerModule {
    @Provides
    fun provideMyLocationsManager(context: Context,saveLocationManager: SaveLocationManager)
            : IMyLocationsManager = MyLocationsManager(context,saveLocationManager)

}
