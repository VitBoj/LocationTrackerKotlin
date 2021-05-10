package com.example.account_module.mvp

import android.content.Context

import com.example.firebase_module.FirebaseHelper
import com.example.location_module.interfaces.IWorkManagerSetUp

import javax.inject.Inject

class AccountModel @Inject constructor() : AccountContract.Model {

    companion object{
        private const val DB_NAME: String = "Locations"
    }

    @Inject
    lateinit var firebaseHelper: FirebaseHelper

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var workManagerSetUp: IWorkManagerSetUp

    @Inject
    lateinit var switchButtonState: ISwitchButtonState

    override fun enableLocationTracking() {
        workManagerSetUp.setUpWorkManager()
    }

    override fun disableLocationTracking() {
        workManagerSetUp.cancelAllWorks()
    }

    override fun exitFromAccount() {
        firebaseHelper.signOutCurrentUser(context)
    }

    override fun clearLocationHistory() {
        val currentUser = firebaseHelper.getCurrentUser(context).uid
        firebaseHelper.clearLocationsDatabase(DB_NAME, currentUser)
    }

    override fun saveSwitchBtnState(boolean: Boolean) {
        switchButtonState.saveState(boolean)
    }

    override fun getSwitchBtnState(): Boolean {
       return switchButtonState.getState()
    }

}