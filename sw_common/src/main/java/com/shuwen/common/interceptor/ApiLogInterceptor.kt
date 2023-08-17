package com.shuwen.common.interceptor

import com.shuwen.common.util.LogUtil
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class ApiLogInterceptor : Interceptor {
    private val charset = Charset.forName("UTF-8")
    private val separator = System.getProperty("line.separator") ?: "\n"

    override fun intercept(chain: Interceptor.Chain): Response {
        // 发起请求日志打印
        val request = chain.request()
        val time = System.currentTimeMillis()
        val logCall = StringBuilder("$HTTP_REQUEST\n").apply {
            append("$HTTP_REQUEST_BEGIN\n")
            append("  URL: ${request.url}\n")
            append("  Method: ${request.method}\n")
            append("  Headers:\n")
            for (i in 0 until request.headers.size) {
                append("   - ${request.headers.name(i)}:${request.headers.value(i)}\n")
            }
            if (request.body != null) {
                append("  RequestBody: ${bodyToString(request)}\n")
            }
            append(HTTP_REQUEST_END)
        }
        LogUtil.d(logCall.toString(), HTTP_LOG)
        // 请求结果日志打印
        val response = chain.proceed(request)
        val duration = System.currentTimeMillis() - time
        val logResult = StringBuilder("$HTTP_RESPONSE\n").apply {
            append("$HTTP_RESPONSE_BEGIN\n")
            append("  URL: ${request.url}\n")
            append("  is success : ${response.isSuccessful} - Received in: ${duration}ms\n")
            append("  Status Code: ${response.code}\n")
            if (!response.isSuccessful) {
                append("  error:${getStringBody(response.body)}\n")
            } else {
                append("  Body:\n")
                if (subtypeIsNotFile(response.body?.contentType()?.subtype)) {
                    val stringBody = getStringBody(response.body)
                    val jsonString = getJsonString(stringBody)
                    jsonString.split(separator.toRegex()).forEach {
                        append("  ${it}\n")
                    }
                } else {
                    append("  body is file")
                }
            }
            append(HTTP_RESPONSE_END)
        }
        LogUtil.d(logResult.toString(), HTTP_LOG)
        return response
    }

    private fun getStringBody(body: ResponseBody?): String {
        if (body == null) return ""
        val source = body.source()
        source.request(Long.MAX_VALUE)
        return source.buffer.clone().readString(charset)
    }

    private fun bodyToString(request: Request): String {
        try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            if (copy.body == null) return ""
            copy.body?.writeTo(buffer)
            return getJsonString(buffer.readUtf8())
        } catch (e: IOException) {
            return "{\"err\": \"" + e.message + "\"}"
        }
    }

    private fun subtypeIsNotFile(subtype: String?) = subtype != null
        && (subtype.contains("json")
        || subtype.contains("xml")
        || subtype.contains("plain")
        || subtype.contains("html"))

    private fun getJsonString(msg: String): String {
        if (msg.isBlank()) return ""
        var message: String
        try {
            message = when {
                msg.startsWith("{") -> {
                    val jsonObject = JSONObject(msg)
                    jsonObject.toString(3)
                }
                msg.startsWith("[") -> {
                    val jsonArray = JSONArray(msg)
                    jsonArray.toString(3)
                }
                else -> {
                    msg
                }
            }
            message = message.replace("\\/", "/")
        } catch (e: JSONException) {
            message = msg
        }
        return message
    }

    companion object {
        const val HTTP_LOG = "Webapi"
        const val HTTP_REQUEST = "Network Request <网络请求开始>"
        const val HTTP_REQUEST_BEGIN = "Okhttp Request Begin:"
        const val HTTP_REQUEST_END = "Okhttp Request End!"
        const val HTTP_RESPONSE = "Network Response <网络请求结束>"
        const val HTTP_RESPONSE_BEGIN = "Okhttp Response Begin:"
        const val HTTP_RESPONSE_END = "Okhttp Response End!"
    }
}