package com.example.location_module

import android.content.Context
import android.location.Location

import com.example.firebase_module.interfaces.IFirebaseHelper
import com.example.location_module.interfaces.ISaveLocationManager

import com.google.android.gms.tasks.Task

import com.orhanobut.hawk.Hawk

import java.io.IOException

import javax.inject.Inject

class SaveLocationManager @Inject constructor(private val firebaseHelper: IFirebaseHelper)
    : ISaveLocationManager {

    companion object{
        private const val DB_LOCATION_TABLE_NAME = "Locations"
    }

    override fun saveLocationToFirebaseDB(location: LocationModel): Task<Void?> {
        val currentDate: String = location.currentDate
        val currentLocation = location.copy()
        return firebaseHelper.getDBReferences(DB_LOCATION_TABLE_NAME)
                .child(location.userId)
                .child(currentDate)
                .push()
                .setValue(currentLocation)
    }

    @Throws(IOException::class)
    override fun saveLocationToLocalDB(location: Location, context: Context) {
        val currentDate: String = LocationFormatting.convertLocTimeToDate(location.time)
        val time: String = LocationFormatting.convertLocTimeToTime(location.time)
        val address: String = LocationFormatting.convertLocationToAddress(
                location.latitude,
                location.longitude,
                context
        )
        val userId: String = firebaseHelper.getCurrentUser(context).uid
        val currentLocation = LocationModel(
                location.latitude,
                location.longitude,
                time,
                address,
                userId,
                currentDate
        )
        val count: Long = Hawk.count()
        Hawk.put(count.toString(), currentLocation)
    }

}