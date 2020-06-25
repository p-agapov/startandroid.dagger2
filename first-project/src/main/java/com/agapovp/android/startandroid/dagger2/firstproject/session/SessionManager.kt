package com.agapovp.android.startandroid.dagger2.firstproject.session

import dagger.Lazy
import javax.inject.Inject

class SessionManager @Inject constructor(private val session: Lazy<Session>) {

    fun getSession(): Session = session.get()
}
