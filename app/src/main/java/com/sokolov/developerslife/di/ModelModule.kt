package com.sokolov.developerslife.di

import com.sokolov.developerslife.api.DevelopersLifeService
import com.sokolov.developerslife.contract.MainContract
import com.sokolov.developerslife.model.MainModelImpl
import dagger.Module
import dagger.Provides


@Module(includes = [RetrofitModule::class])
class ModelModule {

    @Provides
    fun provideModel(modelImpl: MainModelImpl): MainContract.MainModel = modelImpl

    @Provides
    fun provideModelImpl(apiService: DevelopersLifeService): MainModelImpl = MainModelImpl(apiService)
}