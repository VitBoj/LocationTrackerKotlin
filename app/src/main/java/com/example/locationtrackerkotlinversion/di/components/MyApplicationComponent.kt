package com.example.locationtrackerkotlinversion.di.components

import com.example.firebase_module.di.FirebaseHelperModule
import com.example.location_module.di.modules.SaveLocationManagerModule
import com.example.location_module.di.modules.WorkerModule
import com.example.locationtrackerkotlinversion.MyApplication
import com.example.locationtrackerkotlinversion.di.modules.ActivityBindingModule
import com.example.locationtrackerkotlinversion.di.modules.MyApplicationModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule

import javax.inject.Singleton

@Singleton
@Component(
        modules = [MyApplicationModule::class,
            ActivityBindingModule::class,
            AndroidSupportInjectionModule::class,
            WorkerModule::class,
            FirebaseHelperModule::class,
            SaveLocationManagerModule::class
        ])
interface MyApplicationComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication?)

    fun inject(application: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder
        fun build(): MyApplicationComponent
    }

}