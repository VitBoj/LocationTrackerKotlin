package com.example.firebase_module

import android.content.Context

import com.example.firebase_module.interfaces.IFirebaseHelper

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import javax.inject.Inject

class FirebaseHelper @Inject constructor() : IFirebaseHelper {

    override fun authInstance(context: Context): FirebaseAuth {
        FirebaseApp.initializeApp(context)
        return FirebaseAuth.getInstance()
    }

    override fun getDBReferences(dbName: String, child: String): DatabaseReference {
        return FirebaseDatabase.getInstance()
                .getReference(dbName)
                .child(child)
    }

    override fun getDBReferences(dbName: String): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(dbName)
    }

    override fun getCurrentUser(context: Context): FirebaseUser {
        return authInstance(context).currentUser!!
    }

    override fun clearLocationsDatabase(dbName: String, child: String) {
        getDBReferences(dbName).child(child).removeValue()
    }

    override fun signOutCurrentUser(context: Context) {
        authInstance(context).signOut()
    }

}