package com.example.locationtrackerkotlinversion.di.components

import com.example.location_module.di.modules.WorkManagerSetUpModule
import com.example.locationtrackerkotlinversion.WorkManagerRestartReceiver

import dagger.Component

@Component(modules = [WorkManagerSetUpModule::class])
interface WorkManagerRestartReceiverComponent {
    fun inject(workManagerRestartReceiver: WorkManagerRestartReceiver)
}