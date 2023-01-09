package com.shuwen.common.bean

import androidx.lifecycle.MutableLiveData
import com.shuwen.common.base.BaseResp

/**
 * created by shuwen on 1/2/23
 */
class RespStateData<T> : MutableLiveData<BaseResp<T>>()