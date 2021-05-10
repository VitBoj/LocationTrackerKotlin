package com.example.firebase_module.di

import android.content.Context

import com.example.firebase_module.FirebaseRegistration
import com.example.firebase_module.FirebaseFormatter
import com.example.firebase_module.FirebaseHelper
import com.example.firebase_module.interfaces.IFirebaseRegistration
import dagger.Module
import dagger.Provides

@Module
class FirebaseRegistrationModule {
    @Provides
    fun provideFirebaseRegistration(context: Context, firebaseFormatter: FirebaseFormatter, firebaseHelper: FirebaseHelper)
            : IFirebaseRegistration = FirebaseRegistration(context, firebaseFormatter, firebaseHelper)
}