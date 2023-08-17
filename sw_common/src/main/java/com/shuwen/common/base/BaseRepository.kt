package com.shuwen.common.base

import android.util.Log
import com.shuwen.common.bean.RespStateData
import com.shuwen.common.util.Constants
import com.shuwen.common.util.ToastUtil
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * Created by shuwen on 1/2/23.
 */
open class BaseRepository {

    suspend fun <T> dealResp(
        block: suspend () -> BaseResp<T>,
        liveData: RespStateData<T>,
    ) {
        var result = BaseResp<T>()

        try {
            result = block.invoke()

            when (result.errorCode) {
                Constants.HTTP_SUCCESS -> {
                }

                Constants.HTTP_AUTH_INVALID -> {
                    ToastUtil.showMsg("认证过期，请重新登录！")
                }

                else -> {
                    ToastUtil.showMsg("code:" + result.errorCode.toString() + " / msg:" + result.errorMsg)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is UnknownHostException,
                is HttpException,
                is ConnectException,
                -> {
                    ToastUtil.showMsg("网络错误！")
                }

                else -> {
                    ToastUtil.showMsg("未知错误！")
                }
            }
        } finally {
            liveData.value = result
        }
    }

}