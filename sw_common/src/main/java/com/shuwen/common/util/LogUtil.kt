package com.shuwen.common.util

import com.shuwen.sw_common.BuildConfig
import timber.log.Timber

object LogUtil {

    fun initLog() {
        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                if (BuildConfig.DEBUG) {
                    super.log(priority, tag, message, t)
                }
            }
        })
    }

    fun d(msg: String, tag: String? = null) {
        setTag(tag)
        Timber.d(msg)
    }

    fun v(msg: String, tag: String? = null) {
        setTag(tag)
        Timber.v(msg)
    }

    fun i(msg: String, tag: String? = null) {
        setTag(tag)
        Timber.i(msg)
    }

    fun e(msg: String, tag: String? = null) {
        setTag(tag)
        Timber.e(msg)
    }

    fun w(msg: String, tag: String? = null) {
        setTag(tag)
        Timber.w(msg)
    }

    private fun setTag(tag: String? = null) {
        tag?.let { Timber.tag(it) }
    }
}