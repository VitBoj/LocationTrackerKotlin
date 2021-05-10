package com.example.firebase_module.di

import android.content.Context
import com.example.firebase_module.FirebaseLogin
import com.example.firebase_module.FirebaseFormatter
import com.example.firebase_module.FirebaseHelper
import com.example.firebase_module.interfaces.IFirebaseLogin
import dagger.Module
import dagger.Provides

@Module
class FirebaseLoginModule {
    @Provides
    fun provideFirebaseLogin(context: Context, firebaseFormatter: FirebaseFormatter, firebaseHelper: FirebaseHelper)
            : IFirebaseLogin = FirebaseLogin(context, firebaseFormatter, firebaseHelper)
}