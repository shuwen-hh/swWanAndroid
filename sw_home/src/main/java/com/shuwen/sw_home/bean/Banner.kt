package com.shuwen.sw_home.bean

/**
 * created by shuwen on 1/2/23
 */
data class Banner(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)
