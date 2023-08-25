package com.example.testovoe22

import android.app.Application
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "0e5879f4-7960-447c-92bd-ec3779e8c0bb"

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}