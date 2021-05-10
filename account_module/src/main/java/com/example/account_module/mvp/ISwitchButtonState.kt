package com.example.account_module.mvp

interface ISwitchButtonState {

    fun saveState(boolean: Boolean)

    fun getState(): Boolean

}