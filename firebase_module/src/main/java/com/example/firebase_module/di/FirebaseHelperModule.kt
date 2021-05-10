package com.example.firebase_module.di


import com.example.firebase_module.FirebaseHelper
import com.example.firebase_module.interfaces.IFirebaseHelper
import dagger.Binds

import dagger.Module


@Module
abstract class FirebaseHelperModule {
    @Binds
    abstract fun bindFirebaseHelper(firebaseHelper: FirebaseHelper): IFirebaseHelper
}