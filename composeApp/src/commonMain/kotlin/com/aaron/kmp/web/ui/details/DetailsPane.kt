package com.aaron.kmp.web.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun DetailsPane(
    keyword: String?,
    navController: NavHostController,
    vm: DetailsViewModel = viewModel { DetailsViewModel() },
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = keyword ?: "")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier
                        )
                    }
                },
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when(val uiState = vm.uiState) {
                DetailsState.Loading -> {
                    CircularProgressIndicator()
                }
                is DetailsState.Success -> {
                    Text(text = uiState.keyword)
                }
            }
        }
    }
}