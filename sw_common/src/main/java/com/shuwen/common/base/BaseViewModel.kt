package com.shuwen.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * created by shuwen on 1/2/23
 */
open class BaseViewModel : ViewModel() {

    fun launch(block: suspend () -> Unit) {
        viewModelScope.launch {
            block.invoke()
        }
    }

}