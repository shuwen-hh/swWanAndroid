package com.shuwen.swwanandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shuwen.common.base.BaseActivity
import com.shuwen.sw_home.fragment.HomeFragment
import com.shuwen.sw_mine.MineFragment
import com.shuwen.swwanandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, ViewModel>() {

    private lateinit var fragmentList: MutableList<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentList = mutableListOf()
        fragmentList.add(HomeFragment())
        fragmentList.add(MineFragment())

        binding.navHostFragmentActivityMain.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }

        }

        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> binding.navHostFragmentActivityMain.setCurrentItem(0, false)
                R.id.navigation_dashboard -> binding.navHostFragmentActivityMain.setCurrentItem(1, false)
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}