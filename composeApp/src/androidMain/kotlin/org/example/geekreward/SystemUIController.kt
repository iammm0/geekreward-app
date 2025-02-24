package org.example.geekreward

import android.app.Activity
import android.os.Build
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun SystemUiController(
    statusBarColor: Color = Color.Transparent,
    navigationBarColor: Color = Color.Transparent,
    isStatusBarVisible: Boolean = true,
    isNavigationBarVisible: Boolean = true,
    isSystemBarsBehaviorTransient: Boolean = true
) {
    val context = LocalContext.current
    val window = (context as Activity).window
    val insetsController = WindowInsetsControllerCompat(window, window.decorView)

    val isLightTheme = MaterialTheme.colorScheme.primary.luminance() > 0.5

    SideEffect {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // ✅ 设置状态栏颜色
        window.statusBarColor = statusBarColor.toArgb()

        // ✅ 设置导航栏颜色
        window.navigationBarColor = navigationBarColor.toArgb()

        // ✅ 适配亮/暗主题
        insetsController.isAppearanceLightStatusBars = isLightTheme
        insetsController.isAppearanceLightNavigationBars = isLightTheme

        window.insetsController?.let { controller ->
            if (isStatusBarVisible) {
                controller.show(WindowInsets.Type.statusBars())
            } else {
                controller.hide(WindowInsets.Type.statusBars())
            }

            if (isNavigationBarVisible) {
                controller.show(WindowInsets.Type.navigationBars())
            } else {
                controller.hide(WindowInsets.Type.navigationBars())
            }

            val appearance = if (isLightTheme) {
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS or
                        WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
            } else {
                0
            }
            controller.setSystemBarsAppearance(
                appearance,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS or
                        WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
            )

            controller.systemBarsBehavior = if (isSystemBarsBehaviorTransient) {
                WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            } else {
                WindowInsetsController.BEHAVIOR_DEFAULT
            }
        }
    }
}
