package com.aaron.kmp.web.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaron.kmp.web.data.ChefRepo
import kotlinx.coroutines.launch

class HomeViewModel(
    private val chefRepo: ChefRepo = ChefRepo()
) : ViewModel() {

    init {
        viewModelScope.launch {
            val chefList = chefRepo.getChefList()
            println("chefList: $chefList")
        }
    }
}