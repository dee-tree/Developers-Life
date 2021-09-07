package com.sokolov.developerslife.di

import com.sokolov.developerslife.model.MainModelImpl
import com.sokolov.developerslife.ui.MainActivity
import dagger.Component
import javax.inject.Singleton


@Component(modules = [PresenterModule::class])
@Singleton
interface Component {
    fun inject(activity: MainActivity)

    fun inject(model: MainModelImpl)
}