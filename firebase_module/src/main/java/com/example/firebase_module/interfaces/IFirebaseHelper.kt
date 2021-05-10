package com.example.firebase_module.interfaces

import android.content.Context

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference

interface IFirebaseHelper {

    fun authInstance(context: Context): FirebaseAuth

    fun getDBReferences(dbName: String, child: String): DatabaseReference

    fun getDBReferences(dbName: String): DatabaseReference

    fun getCurrentUser(context: Context): FirebaseUser

    fun clearLocationsDatabase(dbName: String, child: String)

    fun signOutCurrentUser(context: Context)

}