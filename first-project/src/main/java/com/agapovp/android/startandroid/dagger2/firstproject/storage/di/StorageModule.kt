package com.agapovp.android.startandroid.dagger2.firstproject.storage.di

import com.agapovp.android.startandroid.dagger2.firstproject.storage.DatabaseHelper
import com.agapovp.android.startandroid.dagger2.firstproject.storage.DatabaseHelperImpl
import com.agapovp.android.startandroid.dagger2.firstproject.storage.DatabaseHelperImplTest
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    @DatabaseProd
    fun provideDatabaseHelper(): DatabaseHelper =
        DatabaseHelperImpl()

    @Provides
    @DatabaseTest
    fun provideDatabaseHelperTest(): DatabaseHelper =
        DatabaseHelperImplTest()
}
