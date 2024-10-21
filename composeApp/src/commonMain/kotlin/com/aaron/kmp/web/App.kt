package com.aaron.kmp.web

import androidx.compose.foundation.layout.imePadding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aaron.kmp.web.nav.Home
import com.aaron.kmp.web.nav.TechList
import com.aaron.kmp.web.ui.home.Home
import com.aaron.kmp.web.ui.list.ListPane
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.imePadding()
        ) {
            composable<Home> {
                Home(navController)
            }

            composable<TechList> {
                ListPane(
                    navController = navController
                )
            }
        }
    }
}