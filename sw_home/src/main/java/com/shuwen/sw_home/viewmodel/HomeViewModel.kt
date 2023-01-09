package com.shuwen.sw_home.viewmodel

import com.shuwen.common.base.BaseViewModel
import com.shuwen.common.bean.RespStateData
import com.shuwen.sw_home.bean.Article
import com.shuwen.sw_home.bean.Banner
import com.shuwen.sw_home.bean.TopArticle
import com.shuwen.sw_home.repo.HomeRepo

/**
 * Created by shuwen on 1/2/23.
 */
class HomeViewModel(private val repo: HomeRepo) : BaseViewModel() {

    var bannerList = RespStateData<List<Banner>>()
    var articleList = RespStateData<Article>()
    var topArticleList = RespStateData<TopArticle>()

    fun getBanner() {
        launch { repo.getBanner(bannerList)}
    }

    fun getArticles(pageIndex: Int) {
        launch { repo.getArticles(articleList, pageIndex)}
    }

    fun getTopArticles() {
        launch { repo.getTopArticles(topArticleList)}
    }

}