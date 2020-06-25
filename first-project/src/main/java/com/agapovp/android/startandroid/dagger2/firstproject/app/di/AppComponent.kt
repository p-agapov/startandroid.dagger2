package com.agapovp.android.startandroid.dagger2.firstproject.app.di

import com.agapovp.android.startandroid.dagger2.firstproject.event.di.HandlerModule
import com.agapovp.android.startandroid.dagger2.firstproject.network.di.NetworkModule
import com.agapovp.android.startandroid.dagger2.firstproject.session.SessionManager
import com.agapovp.android.startandroid.dagger2.firstproject.storage.di.StorageModule
import com.agapovp.android.startandroid.dagger2.firstproject.thread.di.ThreadModule
import com.agapovp.android.startandroid.dagger2.firstproject.view.MainActivity
import dagger.Component

@Component(
    modules = [
        StorageModule::class,
        NetworkModule::class,
        HandlerModule::class,
        ThreadModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun getSessionManager(): SessionManager
}
