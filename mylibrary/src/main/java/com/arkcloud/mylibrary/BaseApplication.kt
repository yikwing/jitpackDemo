package com.arkcloud.mylibrary

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initThridPack()
    }

    private fun initThridPack() {
        initLogger()
    }

}

private fun initLogger() {

    val formatStrategy = PrettyFormatStrategy
        .newBuilder() // (Optional) Changes the log strategy to print out. Default LogCat
        .tag("yikwing")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
        .build()

    Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
        override fun isLoggable(priority: Int, tag: String?): Boolean {
            return BuildConfig.DEBUG
        }
    })
}
