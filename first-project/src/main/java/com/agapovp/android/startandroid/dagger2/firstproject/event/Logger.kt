package com.agapovp.android.startandroid.dagger2.firstproject.event

class Logger : EventHandler {

    override fun getDescription() = "Logger ${this.hashCode()}"
}
