package org.example.geekreward

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform