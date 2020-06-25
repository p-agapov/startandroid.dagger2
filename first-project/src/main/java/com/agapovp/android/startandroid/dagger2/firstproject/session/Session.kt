package com.agapovp.android.startandroid.dagger2.firstproject.session

import javax.inject.Inject

class Session @Inject constructor() {

    fun getStatus() = "Authorised ID:${this.hashCode()}"
}
