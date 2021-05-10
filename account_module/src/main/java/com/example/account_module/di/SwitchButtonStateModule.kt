package com.example.account_module.di

import android.content.Context
import com.example.account_module.SwitchButtonState
import com.example.account_module.mvp.ISwitchButtonState
import dagger.Module
import dagger.Provides

@Module
class SwitchButtonStateModule {
    @Provides
    fun provideSwitchButtonState(context: Context): ISwitchButtonState = SwitchButtonState(context)
}