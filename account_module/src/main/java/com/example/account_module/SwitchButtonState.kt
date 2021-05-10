package com.example.account_module

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

import com.example.account_module.mvp.ISwitchButtonState

import javax.inject.Inject

class SwitchButtonState @Inject constructor(context: Context) : ISwitchButtonState {

    companion object {
        private const val SHARED_PREF_FILE = "switchButtonStateSettings"
        private const val SWITCH_STATE = "switchState"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE, MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    override fun saveState(boolean: Boolean) {
        editor.putBoolean(SWITCH_STATE, boolean)
        editor.apply()
        editor.commit()
    }

    override fun getState(): Boolean {
        return sharedPreferences.getBoolean(SWITCH_STATE, false)
    }
}