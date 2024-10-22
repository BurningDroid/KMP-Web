package com.aaron.kmp.web.ui.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DetailsViewModel(
) : ViewModel() {

    var uiState: DetailsState by mutableStateOf(DetailsState.Loading)
        private set

    init {
        print("DetailsViewModel.init: ${this.hashCode()}")
        viewModelScope.launch {
            delay(3000)
            uiState = DetailsState.Success("Hello, World")
        }
    }
}