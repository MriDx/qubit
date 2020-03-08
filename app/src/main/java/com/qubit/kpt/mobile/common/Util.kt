package com.qubit.kpt.mobile.common

import com.qubit.kpt.mobile.KptMobile
import java.io.IOException
import java.util.*

object Util {
    @Throws(IOException::class)
    fun getProperty(key: String): String {
        val properties = Properties()
        val assetManager = KptMobile.applicationContext.assets
        val inputStream = assetManager.open("config.properties")
        properties.load(inputStream)
        return properties.getProperty(key)

    }
}