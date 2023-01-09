package com.shuwen.sw_home.fragment

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import com.shuwen.common.base.BaseFragment
import com.shuwen.sw_home.viewmodel.HomeViewModel
import com.shuwen.sw_home.R
import com.shuwen.sw_home.adapter.ArticlesAdapter
import com.shuwen.sw_home.adapter.HomeBannerAdapter
import com.shuwen.sw_home.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * created by shuwen on 1/2/23
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModel()
    private var adapter: ArticlesAdapter = ArticlesAdapter()
    var pageIndex = 0

    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        binding.articles.layoutManager = LinearLayoutManager(context)
        binding.articles.adapter = adapter
    }

    override fun initData() {
        viewModel.getBanner()
//        viewModel.getTopArticles()
        viewModel.getArticles(pageIndex)
        adapter.reloadListener = object : ArticlesAdapter.ReloadListener{
            override fun onReload() {
                pageIndex += 1
                viewModel.getArticles(pageIndex)
            }

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun initObserve() {
        viewModel.bannerList.observe(this) {
            viewModel.bannerList.value?.data?.let {
                binding.homeBanner.setAdapter(HomeBannerAdapter(it))
            }
        }
        viewModel.articleList.observe(this) {
            viewModel.articleList.value?.data?.let {
                adapter.article.addAll(0, it.datas)
            }
            adapter.notifyItemRangeInserted(pageIndex * 19,pageIndex * 19 + 19)
        }
//        viewModel.topArticleList.observe(this) {
//            viewModel.topArticleList.value?.data?.let {
//
//            }
//        }
    }

}