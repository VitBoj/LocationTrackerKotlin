package com.example.locationtrackerkotlinversion

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

import com.example.location_module.interfaces.IWorkManagerSetUp

import javax.inject.Inject

class WorkManagerRestartReceiver : BroadcastReceiver() {

    @Inject
    lateinit var workManagerSetUp: IWorkManagerSetUp

    override fun onReceive(context: Context, intent: Intent?) {
        if (intent != null) {
            if (intent.action.equals(Intent.ACTION_BOOT_COMPLETED)) {
                workManagerSetUp.setUpWorkManager()
            }
        }
    }

}