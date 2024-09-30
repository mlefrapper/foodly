package com.mlefrapper.foodly

import android.app.Application
import com.mlefrapper.foodly.util.ReleaseTimberTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class FoodlyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(
            if (BuildConfig.DEBUG) Timber.DebugTree() else ReleaseTimberTree()
        )
    }
}
