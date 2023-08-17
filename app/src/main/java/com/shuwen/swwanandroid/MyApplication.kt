package com.shuwen.swwanandroid

import android.app.Application
import com.shuwen.common.util.LogUtil
import com.shuwen.common.util.ToastUtil
import com.shuwen.sw_home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

/**
 * created by shuwen on 1/2/23
 */
class MyApplication : Application() {

    private val modules = mutableListOf(homeModule)

    override fun onCreate() {
        super.onCreate()
        ToastUtil.init(this)
        LogUtil.initLog()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(modules)
        }
    }

}