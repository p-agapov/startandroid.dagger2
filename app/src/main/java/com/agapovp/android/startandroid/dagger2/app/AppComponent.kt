package com.agapovp.android.startandroid.dagger2.app

import com.agapovp.android.startandroid.dagger2.MainActivity
import com.agapovp.android.startandroid.dagger2.network.NetworkModule
import com.agapovp.android.startandroid.dagger2.storage.StorageModule
import dagger.Component

@Component(modules = [StorageModule::class, NetworkModule::class])
interface AppComponent {

    fun injectsMainActivity(mainActivity: MainActivity)
}
