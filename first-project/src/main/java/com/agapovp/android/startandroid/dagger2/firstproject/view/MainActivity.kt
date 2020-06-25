package com.agapovp.android.startandroid.dagger2.firstproject.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.agapovp.android.startandroid.dagger2.firstproject.R
import com.agapovp.android.startandroid.dagger2.firstproject.app.App
import com.agapovp.android.startandroid.dagger2.firstproject.databinding.ActivityMainBinding
import com.agapovp.android.startandroid.dagger2.firstproject.event.EventHandler
import com.agapovp.android.startandroid.dagger2.firstproject.network.NetworkUtils
import com.agapovp.android.startandroid.dagger2.firstproject.session.SessionManager
import com.agapovp.android.startandroid.dagger2.firstproject.storage.DatabaseHelper
import com.agapovp.android.startandroid.dagger2.firstproject.storage.di.DatabaseProd
import com.agapovp.android.startandroid.dagger2.firstproject.storage.di.DatabaseTest
import com.agapovp.android.startandroid.dagger2.firstproject.thread.ThreadHandler
import com.agapovp.android.startandroid.dagger2.firstproject.thread.ThreadHandlerType
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    private val counter = MutableLiveData<Int>().apply {
        value = 0
    }

    private lateinit var dataBinding: ActivityMainBinding

    private lateinit var sessionManager: SessionManager

    //@field:[Inject Named("prod")]
    @Inject
    @Named("prod")
    lateinit var networkUtils: NetworkUtils

    @Inject
    @DatabaseProd
    lateinit var databaseHelper: DatabaseHelper

    //@field:[Inject Named("prod")]
    @Inject
    @Named("test")
    lateinit var mNetworkUtilsProvider: Provider<NetworkUtils>

    @Inject
    @DatabaseTest
    lateinit var mDatabaseHelperProvider: Lazy<DatabaseHelper>

    @Inject
    @Named("logger")
    @JvmSuppressWildcards
    lateinit var eventHandlers: Set<EventHandler>

    @Inject
    @JvmSuppressWildcards
    lateinit var networkUtilsSet: Set<NetworkUtils>

    @Inject
    @JvmSuppressWildcards
    lateinit var threadHandlerMap: Map<ThreadHandlerType, ThreadHandler>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        injectDependencies()
        observeLiveData()
        logDependencies()
        bind()
    }

    override fun onDestroy() {
        super.onDestroy()
        unbind()
    }

    fun incrementCounter() {
        counter.value = counter.value?.plus(1)
        Log.d(LOG_TAG, "Counter incremented.")
    }

    @Inject
    internal fun showToast() {
        Toast.makeText(this, "Invoked by @Inject annotation.", Toast.LENGTH_LONG).show()
    }

    private fun injectDependencies() {
        App.getComponent().inject(this)
        sessionManager = App.getComponent().getSessionManager()
    }

    private fun bind() {
        dataBinding.mainActivity = this
    }

    private fun unbind() {
        dataBinding.mainActivity = null
    }

    private fun observeLiveData() {
        counter.observe(this, Observer {
            it?.let {
                dataBinding.tvCounter.text = it.toString()
            }
        })
    }

    private fun logDependencies() {
        Log.d(LOG_TAG, "Eager 1:")
        Log.d(LOG_TAG, networkUtils.getDescription())
        Log.d(LOG_TAG, databaseHelper.getDescription())

        Log.d(LOG_TAG, "Eager 2:")
        Log.d(LOG_TAG, networkUtils.getDescription())
        Log.d(LOG_TAG, databaseHelper.getDescription())

        Log.d(LOG_TAG, "Lazy 1:")
        Log.d(LOG_TAG, mNetworkUtilsProvider.get().getDescription())
        Log.d(LOG_TAG, mDatabaseHelperProvider.get().getDescription())

        Log.d(LOG_TAG, "Lazy 2:")
        Log.d(LOG_TAG, mNetworkUtilsProvider.get().getDescription())
        Log.d(LOG_TAG, mDatabaseHelperProvider.get().getDescription())

        Log.d(LOG_TAG, "Into set:")
        eventHandlers.forEach {
            Log.d(LOG_TAG, it.getDescription())
        }

        Log.d(LOG_TAG, "Elements into set:")
        networkUtilsSet.forEach {
            Log.d(LOG_TAG, it.getDescription())
        }

        Log.d(LOG_TAG, "Into map:")
        threadHandlerMap.forEach {
            Log.d(LOG_TAG, "${it.key} -> ${it.value.getDescription()}")
        }

        Log.d(LOG_TAG, "Constructor no module:")
        Log.d(LOG_TAG, sessionManager.getSession().getStatus())
    }

    companion object {
        private const val LOG_TAG = "MainActivityDebug"
    }
}
