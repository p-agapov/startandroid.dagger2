package com.agapovp.android.startandroid.dagger2.storage

import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    fun provideDatabaseHelper() = DatabaseHelper()
}
