package com.shuwen.common.base

class BaseResp<T> {
    var errorCode: Int = -1
    var errorMsg: String = ""
    var data: T? = null
}