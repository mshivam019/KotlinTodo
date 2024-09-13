package com.mshivam019.kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform