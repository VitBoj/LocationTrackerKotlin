package com.example.account_module.mvp

import android.content.Intent

interface AccountContract {

    interface View {
        fun configurationUI()

        fun bindingUI()

        fun moveToLoginPage(intent: Intent)

        fun showDeleteMessage()
    }

    interface Presenter {
        fun switchBtnOff()

        fun onExitBtnClicked()

        fun onClearLocationHistoryBtnClicked()

        fun switchBtnOn()

        fun getSwitchBtnState(): Boolean
    }

    interface Model {
        fun enableLocationTracking()

        fun disableLocationTracking()

        fun exitFromAccount()

        fun clearLocationHistory()

        fun saveSwitchBtnState(boolean: Boolean)

        fun getSwitchBtnState(): Boolean
    }
}