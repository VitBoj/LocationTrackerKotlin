package com.example.location_module

data class LocationModel(
        var latitude: Double,
        var longitude: Double,
        var locationTime: String,
        var locationAddress: String,
        var userId: String,
        var currentDate: String
)