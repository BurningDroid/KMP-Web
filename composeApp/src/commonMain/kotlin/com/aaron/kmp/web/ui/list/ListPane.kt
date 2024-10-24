package com.aaron.kmp.web.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.aaron.kmp.web.nav.Details

@Composable
fun ListPane(
    navController: NavHostController,
    vm: ListViewModel = viewModel { ListViewModel() },
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "List")
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
            ListItems(
                list = vm.list,
                onClick = { item ->
                    navController.navigate(Details(item))
                }
            )
        }
    }
}

@Composable
private fun ListItems(
    list: List<String>,
    onClick: (String) -> Unit
) {
    LazyColumn {
        items(list) { item ->
            ListItem(
                text = item,
                onClick = onClick
            )
        }
    }
}

@Composable
private fun ListItem(
    text: String,
    onClick: (String) -> Unit
) {
    Text(
        text = text,
        modifier = Modifier
            .clickable(onClick = { onClick(text) })
            .padding(
                horizontal = 20.dp,
                vertical = 12.dp
            )
    )
}