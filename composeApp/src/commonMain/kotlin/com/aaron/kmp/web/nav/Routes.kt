package com.aaron.kmp.web.nav

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object TechList

@Serializable
data class Details(
    val keyword: String
)