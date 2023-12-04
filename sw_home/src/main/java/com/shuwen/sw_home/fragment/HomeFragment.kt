package com.shuwen.sw_home.fragment

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.shuwen.common.base.BaseFragment
import com.shuwen.sw_home.viewmodel.HomeViewModel
import com.shuwen.sw_home.adapter.ArticlesAdapter
import com.shuwen.sw_home.adapter.HomeBannerAdapter
import com.shuwen.sw_home.bean.Article
import com.shuwen.sw_home.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * created by shuwen on 1/2/23
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModel()
    private var adapter: ArticlesAdapter = ArticlesAdapter()
    private var pageIndex = 0
    private var articleDetailList = mutableListOf<Article.ArticleDetail>()

    override fun initViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.articles.layoutManager = LinearLayoutManager(context)
        binding.articles.adapter = adapter
        binding.refreshLayout.setOnLoadMoreListener {
            pageIndex += 1
            viewModel.getArticles(pageIndex) {
                it.finishLoadMore()
            }
        }

        binding.refreshLayout.setOnRefreshListener {
            pageIndex = 0
            viewModel.getArticles(pageIndex) {
                it.finishRefresh()
            }
        }
    }

    override fun initData() {
        viewModel.getBanner()
//        viewModel.getTopArticles()
        viewModel.getArticles(pageIndex)

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun initObserve() {
        viewModel.bannerList.observe(this) {
            if (it.data != null) {
                binding.homeBanner.setAdapter(HomeBannerAdapter(it.data!!))
            }
        }
        viewModel.articleList.observe(this) {
            if (it.data != null) {
                if (pageIndex == 0) {
                    articleDetailList.clear()
                }
                articleDetailList.addAll(it.data!!.datas)

                adapter.setData(mutableListOf<Article.ArticleDetail>().apply {
                    addAll(
                        articleDetailList
                    )
                })
            }
        }
//        viewModel.topArticleList.observe(this) {
//            viewModel.topArticleList.value?.data?.let {
//
//            }
//        }
    }

}