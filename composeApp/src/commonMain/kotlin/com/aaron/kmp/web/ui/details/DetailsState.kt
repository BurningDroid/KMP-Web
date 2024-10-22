package com.aaron.kmp.web.ui.details

sealed class DetailsState {
    data object Loading : DetailsState()
    data class Success(val keyword: String) : DetailsState()
}