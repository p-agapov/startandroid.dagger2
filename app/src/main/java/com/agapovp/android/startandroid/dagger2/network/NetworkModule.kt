package com.agapovp.android.startandroid.dagger2.network

import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideNetworkUtils() = NetworkUtils()
}
