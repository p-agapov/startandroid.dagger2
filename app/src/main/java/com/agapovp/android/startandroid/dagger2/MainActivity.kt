package com.agapovp.android.startandroid.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agapovp.android.startandroid.dagger2.app.App
import com.agapovp.android.startandroid.dagger2.network.NetworkUtils
import com.agapovp.android.startandroid.dagger2.storage.DatabaseHelper
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var databaseHelper: DatabaseHelper

    @Inject
    lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.getComponent().injectsMainActivity(this)
    }
}
