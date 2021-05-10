package com.example.location_module.interfaces

import android.content.Context
import android.location.Location

import com.example.location_module.LocationModel
import com.google.android.gms.tasks.Task

interface ISaveLocationManager {

    fun saveLocationToFirebaseDB(location: LocationModel): Task<Void?>

    fun saveLocationToLocalDB(location: Location, context: Context)

}