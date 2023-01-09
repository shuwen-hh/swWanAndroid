package com.shuwen.sw_home.di

import com.shuwen.common.util.HttpUtil
import com.shuwen.sw_home.api.HomeApi
import com.shuwen.sw_home.repo.HomeRepo
import com.shuwen.sw_home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single { HttpUtil.getService(HomeApi::class.java) }
    single { HomeRepo(get()) }
    viewModel { HomeViewModel(get()) }
}