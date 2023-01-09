package com.shuwen.sw_mine

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shuwen.sw_mine.databinding.FragmentMineBinding

class MineFragment : Fragment() {

    private var binding: FragmentMineBinding? = null

    private lateinit var viewModel: MineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[MineViewModel::class.java]
        binding = FragmentMineBinding.inflate(inflater, container, false)
        return binding?.root
    }

}