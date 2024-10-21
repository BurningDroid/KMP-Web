package com.aaron.kmp.web.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun ListPane(
    navController: NavHostController,
    vm: ListViewModel = viewModel { ListViewModel() },
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text(text = "Back")
        }
        Text(
            text = "List",
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 12.dp
                ),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )

        ListItems(vm.list)
    }
}

@Composable
private fun ListItems(list: List<String>) {
    LazyColumn {
        items(list) { item ->
            ListItem(item)
        }
    }
}

@Composable
private fun ListItem(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(
            horizontal = 20.dp,
            vertical = 12.dp
        )
    )
}