package com.example.locationtrackerkotlinversion.di.modules

import com.example.locationtrackerkotlinversion.mvp.MainActivity
import com.example.locationtrackerkotlinversion.mvp.MainContract
import com.example.locationtrackerkotlinversion.mvp.MainPresenter

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun provideMainActivityView(activity: MainActivity): MainContract.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideMainActivityPresenter(mainView: MainContract.View)
        : MainContract.Presenter = MainPresenter(mainView)
    }
}
