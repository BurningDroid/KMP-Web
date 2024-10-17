package com.aaron.kmp.web

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform