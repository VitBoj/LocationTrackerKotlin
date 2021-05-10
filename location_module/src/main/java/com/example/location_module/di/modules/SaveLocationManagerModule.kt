package com.example.location_module.di.modules

import com.example.firebase_module.FirebaseHelper
import com.example.location_module.SaveLocationManager
import com.example.location_module.interfaces.ISaveLocationManager

import dagger.Module
import dagger.Provides

@Module
class SaveLocationManagerModule {
    @Provides
    fun provideSaveLocationManager(firebaseHelper: FirebaseHelper)
    : ISaveLocationManager = SaveLocationManager(firebaseHelper)

}