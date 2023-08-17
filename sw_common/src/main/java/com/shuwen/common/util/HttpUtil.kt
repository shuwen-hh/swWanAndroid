package com.shuwen.common.util

import android.util.Log
import com.shuwen.common.interceptor.ApiLogInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpUtil {

    private const val BASE_URL = "https://www.wanandroid.com/"

    private var retrofit: Retrofit

    private const val CONNECT_TIME = 5L
    private const val READ_WRITE_TIME = 10L

    init {
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(CONNECT_TIME, TimeUnit.SECONDS)
            .readTimeout(READ_WRITE_TIME, TimeUnit.SECONDS)
            .writeTimeout(READ_WRITE_TIME, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .followRedirects(false)
            .addInterceptor(ApiLogInterceptor())
            .build()

        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> getService(service: Class<T>): T {
        return retrofit.create(service)
    }

}