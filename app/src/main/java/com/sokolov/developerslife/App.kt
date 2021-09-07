package com.sokolov.developerslife

import android.app.Application
import com.sokolov.developerslife.di.Component
import com.sokolov.developerslife.di.DaggerComponent
import com.sokolov.developerslife.di.ModelModule
import com.sokolov.developerslife.di.PresenterModule

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var component: Component
        private set

    override fun onCreate() {
        super.onCreate()

        instance = this

        component = DaggerComponent.builder()
            .modelModule(ModelModule())
            .presenterModule(PresenterModule())
            .build()
    }

}