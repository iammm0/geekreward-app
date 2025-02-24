package org.example.geekreward

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.geekreward.main.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "GeekReward_App",
    ) {
        App()
    }
}