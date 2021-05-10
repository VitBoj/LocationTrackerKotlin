package com.example.location_module


import android.content.ContentValues.TAG
import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.location_module.interfaces.IMyLocationsManager
import com.example.location_module.interfaces.ISaveLocationManager
import java.io.IOException
import javax.inject.Inject



class MyLocationsManager @Inject constructor(private var context: Context, saveLocationManager: ISaveLocationManager) : IMyLocationsManager {

    companion object{
        const val LOCATION_INTERVAL = 300000
        const val LOCATION_DISTANCE = 60f
    }

    private var mLocationManager: LocationManager? = null

    var mLocationListeners = arrayOf(
            LocationListener(LocationManager.GPS_PROVIDER, context, saveLocationManager),
            LocationListener(LocationManager.NETWORK_PROVIDER, context, saveLocationManager)
    )

    override fun initLocationManager() {

        Handler(Looper.getMainLooper()).post {
            Log.e(TAG, "initializeLocationManager")
            if (mLocationManager == null) {
                mLocationManager = context
                        .getSystemService(Context.LOCATION_SERVICE) as LocationManager?
            }
            try {
                mLocationManager?.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER, LOCATION_INTERVAL.toLong(), LOCATION_DISTANCE,
                        mLocationListeners[1]
                )
            } catch (ex: SecurityException) {
                Log.i(TAG, "fail to request location update, ignore", ex)
            } catch (ex: IllegalArgumentException) {
                Log.d(TAG, "network provider does not exist, " + ex.message)
            }
            try {
                mLocationManager?.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER, LOCATION_INTERVAL.toLong(), LOCATION_DISTANCE,
                        mLocationListeners[0]
                )
            } catch (ex: SecurityException) {
                Log.i(TAG, "fail to request location update, ignore", ex)
            } catch (ex: IllegalArgumentException) {
                Log.d(TAG, "gps provider does not exist " + ex.message)
            }
        }
    }

    //Location listener
    class LocationListener(provider: String, private var context: Context, private val saveLocationManager: ISaveLocationManager) : android.location.LocationListener {
        private var mLastLocation: Location
        override fun onLocationChanged(location: Location) {
            Log.e(TAG, "onLocationChanged: $location")
            mLastLocation.set(location)
            try {
                saveLocationManager.saveLocationToLocalDB(mLastLocation, context)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        override fun onProviderDisabled(provider: String) {
            Log.e(TAG, "onProviderDisabled: $provider")
        }

        override fun onProviderEnabled(provider: String) {
            Log.e(TAG, "onProviderEnabled: $provider")
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {
            Log.e(TAG, "onStatusChanged: $provider")
        }

        init {
            Log.e(TAG, "LocationListener $provider")
            mLastLocation = Location(provider)
        }
    }


}