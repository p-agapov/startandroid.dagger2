package com.agapovp.android.startandroid.dagger2.app

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.create()
    }

    companion object {

        private lateinit var component: AppComponent

        fun getComponent() = component
    }
}
