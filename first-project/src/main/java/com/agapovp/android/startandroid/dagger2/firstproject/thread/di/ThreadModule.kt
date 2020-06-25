package com.agapovp.android.startandroid.dagger2.firstproject.thread.di

import com.agapovp.android.startandroid.dagger2.firstproject.thread.*
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ThreadModule {

    @Provides
    @IntoMap
    @ThreadHandlerTypeKey(ThreadHandlerType.UI)
    fun provideThreadHandlerUi(): ThreadHandler =
        ThreadHandlerUi()

    @Provides
    @IntoMap
    @ThreadHandlerTypeKey(ThreadHandlerType.DB)
    fun provideThreadHandlerDb(): ThreadHandler =
        ThreadHandlerDb()
}
