package com.qubit.kpt.mobile

import android.app.Application
import android.content.Context

class KptMobile : Application() {

    init { INSTANCE = this }

    companion object {
        lateinit var INSTANCE: KptMobile
            private set

        val applicationContext: Context get() { return INSTANCE.applicationContext }
    }
}