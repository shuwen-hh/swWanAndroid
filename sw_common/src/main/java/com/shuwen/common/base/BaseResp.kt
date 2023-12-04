package com.shuwen.common.base

class BaseResp<T> {
    /** 0代表成功，-1001代表登录失效**/
    var errorCode: Int = -1
    var errorMsg: String = ""
    var data: T? = null
}