package com.example.account_module.mvp

import android.content.Context

import com.example.navigation_module.INavigation

import javax.inject.Inject

class AccountPresenter @Inject constructor(private val view: AccountContract.View)
    : AccountContract.Presenter {

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var model: AccountModel

    @Inject
    lateinit var navigation: INavigation

    override fun switchBtnOn() {
        model.enableLocationTracking()
        model.saveSwitchBtnState(true)
    }

    override fun getSwitchBtnState(): Boolean {
        return model.getSwitchBtnState()
    }

    override fun switchBtnOff() {
        model.disableLocationTracking()
        model.saveSwitchBtnState(false)
    }

    override fun onExitBtnClicked() {
        model.exitFromAccount()
        model.disableLocationTracking()
        view.moveToLoginPage(navigation.toLogin())
    }

    override fun onClearLocationHistoryBtnClicked() {
        model.clearLocationHistory()
        view.showDeleteMessage()
    }


}