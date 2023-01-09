package com.shuwen.sw_home.api

import com.shuwen.common.base.BaseResp
import com.shuwen.sw_home.bean.Article
import com.shuwen.sw_home.bean.Banner
import com.shuwen.sw_home.bean.TopArticle
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * created by shuwen on 1/2/23
 * retrofit 接口类
 */
interface HomeApi {

    @GET("banner/json")
    suspend fun getBanner(): BaseResp<List<Banner>>

    @GET("article/list/{page}/json")
    suspend fun getArticles(
        @Path("page")page: Int
    ): BaseResp<Article>

    @GET("article/top/json")
    suspend fun getTopArticles(): BaseResp<TopArticle>

}