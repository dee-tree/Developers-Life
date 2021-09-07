package com.sokolov.developerslife.di

import com.sokolov.developerslife.api.DevelopersLifeService
import com.sokolov.developerslife.api.RetrofitInstance
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideApiService(): Class<DevelopersLifeService> = DevelopersLifeService::class.java

    @Provides
    @Singleton
    fun provideRetrofitInstance(apiService: Class<DevelopersLifeService>): DevelopersLifeService = RetrofitInstance.instance.create(apiService)
}