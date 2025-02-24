package org.example.geekreward.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GeekRewardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // 根据系统的主题设置确定是否使用深色模式
    content: @Composable () -> Unit // 接收 Composable 函数作为参数，表示应用的内容
) {
    // 黑白灰色彩方案
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFF212121), // 深灰色主色调
            onPrimary = Color(0xFFFFFFFF), // 白色文字
            secondary = Color(0xFF757575), // 中灰色次要色调
            onSecondary = Color(0xFF212121), // 深灰色文字
            tertiary = Color(0xFFBDBDBD), // 浅灰色
            background = Color(0xFF121212), // 深色背景
            surface = Color(0xFF212121), // 深灰色卡片
            onBackground = Color(0xFFFFFFFF), // 白色文字
            onSurface = Color(0xFFFFFFFF) // 白色文字
        )
    } else {
        lightColorScheme(
            primary = Color(0xFFFFFFFF), // 白色主色调
            onPrimary = Color(0xFF212121), // 深灰色文字
            secondary = Color(0xFFBDBDBD), // 浅灰色次要色调
            onSecondary = Color(0xFF212121), // 深灰色文字
            tertiary = Color(0xFF757575), // 中灰色
            background = Color(0xFFF5F5F5), // 浅色背景
            surface = Color(0xFFFFFFFF), // 白色卡片
            onBackground = Color(0xFF212121), // 深灰色文字
            onSurface = Color(0xFF212121) // 深灰色文字
        )
    }

    // 设置应用的字体样式
    val typography = androidx.compose.material3.Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Serif, // 正文字体为衬线体
            fontWeight = FontWeight.Normal, // 正文字体的粗细为正常
            fontSize = 16.sp, // 正文字体大小为 16sp
            color = if (darkTheme) Color(0xFFFFFFFF) else Color(0xFF212121) // 根据主题切换文字颜色
        ),
        titleLarge = TextStyle(
            fontFamily = FontFamily.Serif, // 标题字体为衬线体
            fontWeight = FontWeight.Bold, // 标题字体加粗
            fontSize = 24.sp, // 标题字体大小为 24sp
            color = if (darkTheme) Color(0xFFFFFFFF) else Color(0xFF212121) // 根据主题切换标题颜色
        ),
        labelSmall = TextStyle(
            fontFamily = FontFamily.SansSerif, // 小标签字体为无衬线体
            fontWeight = FontWeight.Medium, // 字体粗细为中等
            fontSize = 12.sp, // 字体大小为 12sp
            color = if (darkTheme) Color(0xFFBDBDBD) else Color(0xFF757575) // 根据主题切换小标签颜色
        )
    )

    // 设置应用的形状样式
    val shapes = Shapes(
        small = RoundedCornerShape(8.dp), // 小型组件的圆角为 8dp
        medium = RoundedCornerShape(16.dp), // 中型组件的圆角为 16dp
        large = RoundedCornerShape(24.dp) // 大型组件的圆角为 24dp
    )

    // 使用 Material3 主题，将颜色、字体和形状应用于整个应用
    MaterialTheme(
        colorScheme = colors, // 应用的颜色方案
        typography = typography, // 应用的字体样式
        shapes = shapes, // 应用的形状样式
        content = content // 应用的内容（传递给 Composable 函数）
    )
}
