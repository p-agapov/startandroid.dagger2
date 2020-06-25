package com.agapovp.android.startandroid.dagger2.firstproject.event.di

import com.agapovp.android.startandroid.dagger2.firstproject.event.AnalyticsManager
import com.agapovp.android.startandroid.dagger2.firstproject.event.EventHandler
import com.agapovp.android.startandroid.dagger2.firstproject.event.Logger
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Named

@Module
class HandlerModule {

    @Provides
    @IntoSet
    @Named("analytics")
    fun provideAnalyticsManager(): EventHandler =
        AnalyticsManager()

    @Provides
    @IntoSet
    @Named("logger")
    fun provideLogger(): EventHandler =
        Logger()
}
