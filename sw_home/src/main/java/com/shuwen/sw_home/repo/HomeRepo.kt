package com.shuwen.sw_home.repo

import com.shuwen.common.base.BaseRepository
import com.shuwen.common.bean.RespStateData
import com.shuwen.sw_home.api.HomeApi
import com.shuwen.sw_home.bean.Article
import com.shuwen.sw_home.bean.Banner
import com.shuwen.sw_home.bean.TopArticle


/**
 * Created by shuwen on 1/2/23.
 *
 */
class HomeRepo(private val api: HomeApi) : BaseRepository() {

    suspend fun getBanner(data: RespStateData<List<Banner>>) = dealResp(
        { api.getBanner() }, data
    )

    suspend fun getArticles(data: RespStateData<Article>, pageIndex: Int) = dealResp(
        { api.getArticles(pageIndex) }, data
    )

    suspend fun getTopArticles(data: RespStateData<TopArticle>) = dealResp(
        { api.getTopArticles() }, data
    )

}