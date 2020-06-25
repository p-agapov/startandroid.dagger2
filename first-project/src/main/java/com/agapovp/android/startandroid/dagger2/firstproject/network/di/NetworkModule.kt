package com.agapovp.android.startandroid.dagger2.firstproject.network.di

import com.agapovp.android.startandroid.dagger2.firstproject.network.NetworkUtils
import com.agapovp.android.startandroid.dagger2.firstproject.network.NetworkUtilsImpl
import com.agapovp.android.startandroid.dagger2.firstproject.network.NetworkUtilsImplTest
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    @Named("prod")
    fun provideNetworkUtils(): NetworkUtils =
        NetworkUtilsImpl()

    @Provides
    @Named("test")
    fun provideNetworkUtilsTest(): NetworkUtils =
        NetworkUtilsImplTest()

    @Provides
    @ElementsIntoSet
    fun provideSetOfNetworkUtils(): Set<NetworkUtils> =
        setOf(NetworkUtilsImpl(), NetworkUtilsImplTest())
}
