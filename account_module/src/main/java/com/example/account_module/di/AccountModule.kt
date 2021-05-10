package com.example.account_module.di


import com.example.account_module.mvp.AccountActivity
import com.example.account_module.mvp.AccountContract
import com.example.account_module.mvp.AccountPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
abstract class AccountModule {

    @Binds
    abstract fun provideAccountActivityView(activity: AccountActivity): AccountContract.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideAccountActivityPresenter(accountActivityView: AccountContract.View): AccountContract.Presenter =
                AccountPresenter(accountActivityView)
    }


}