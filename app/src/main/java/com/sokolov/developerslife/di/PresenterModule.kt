package com.sokolov.developerslife.di

import com.sokolov.developerslife.contract.MainContract
import com.sokolov.developerslife.presenter.MainPresenterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [ModelModule::class])
class PresenterModule {

    @Provides
    fun providePresenter(presenterImpl: MainPresenterImpl): MainContract.MainPresenter = presenterImpl

    @Provides
    fun providePresenterImpl(model: MainContract.MainModel): MainPresenterImpl  = MainPresenterImpl(model)
}