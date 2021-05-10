package com.example.location_module

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import android.location.Geocoder

import java.io.IOException

import java.text.SimpleDateFormat

import java.util.*

class LocationFormatting {

    companion object {
        @SuppressLint("SimpleDateFormat")
        private val dateFormat: SimpleDateFormat = SimpleDateFormat("ddMMyyyy")

        @SuppressLint("SimpleDateFormat")
        private val timeFormat: SimpleDateFormat = SimpleDateFormat("HH:mm")

        fun convertLocTimeToDate(locationTime: Long): String {
            val date = Date(locationTime)
            return dateFormat.format(date)
        }

        fun convertLocTimeToTime(locationTime: Long): String {
            val date = Date(locationTime)
            return timeFormat.format(date)
        }

        @Throws(IOException::class)
        fun convertLocationToAddress(
                latitude: Double,
                longitude: Double,
                context: Context
        ): String {
            var locationAddress = ""
            val addresses: List<Address>
            val geocoder = Geocoder(context)
            addresses = geocoder.getFromLocation(latitude, longitude, 1)
            try {
                locationAddress = addresses[0].getAddressLine(0)
            } catch (ex: IndexOutOfBoundsException) {
                ex.printStackTrace()
            }
            return locationAddress
        }
    }

}