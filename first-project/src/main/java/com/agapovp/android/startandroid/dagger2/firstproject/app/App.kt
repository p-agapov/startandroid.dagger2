package com.agapovp.android.startandroid.dagger2.firstproject.app

import android.app.Application
import com.agapovp.android.startandroid.dagger2.firstproject.app.di.AppComponent
import com.agapovp.android.startandroid.dagger2.firstproject.app.di.DaggerAppComponent

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
