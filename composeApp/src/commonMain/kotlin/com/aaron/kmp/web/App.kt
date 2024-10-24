package com.aaron.kmp.web

import androidx.compose.foundation.layout.imePadding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aaron.kmp.web.nav.Details
import com.aaron.kmp.web.nav.Home
import com.aaron.kmp.web.nav.TechList
import com.aaron.kmp.web.theme.colors
import com.aaron.kmp.web.ui.details.DetailsPane
import com.aaron.kmp.web.ui.home.HomePane
import com.aaron.kmp.web.ui.list.ListPane
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme(
        colors = colors
    ) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.imePadding()
        ) {
            composable<Home> {
                HomePane(navController)
            }

            composable<TechList> {
                ListPane(
                    navController = navController
                )
            }

            composable<Details> {
                val keyword = it.arguments?.getString("keyword")
                DetailsPane(
                    keyword = keyword,
                    navController = navController
                )
            }
        }
    }
}