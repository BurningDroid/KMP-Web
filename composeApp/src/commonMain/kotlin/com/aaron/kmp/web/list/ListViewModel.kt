package com.aaron.kmp.web.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    var list: List<String> by mutableStateOf(listOf())
        private set

    init {
        viewModelScope.launch {
            list = loadData()
        }
    }

    private fun loadData(): List<String> {
        return listOf("google", "kotlin", "jetbrain", "android", "jetpack", "kmp", "compose", "flutter", "dart", "apple", "ios")
    }
}