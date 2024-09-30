package com.mlefrapper.foodly.util

import android.util.Log
import timber.log.Timber

class ReleaseTimberTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }
    }
}