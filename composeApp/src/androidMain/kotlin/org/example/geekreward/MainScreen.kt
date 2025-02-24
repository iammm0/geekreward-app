package org.example.geekreward

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.example.geekreward.navigation.MainGraph

@Composable
fun MainScreen(navController: NavHostController) {
    // 当前选中的路由
    val currentRoute = navController.currentDestination?.route

    val bottomItems = listOf(
        BottomNavItem.Bounty,
        BottomNavItem.Geek,
        BottomNavItem.Notification,
        BottomNavItem.User
    )

    // 为选中的图标颜色应用动画效果
    val selectedIconColor by animateColorAsState(
        targetValue = if (currentRoute == bottomItems.first().route) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface,
        animationSpec = tween(durationMillis = 300)
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.background, // 设置底部导航栏的背景颜色
            ) {
                bottomItems.forEach { bottomNavItem ->
                    NavigationBarItem(
                        selected = currentRoute == bottomNavItem.route,
                        onClick = {
                            // 导航控制：当点击项时，跳转并保存状态
                            navController.navigate(bottomNavItem.route) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) { saveState = true }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            // 图标颜色根据选中状态动态变化
                            Icon(
                                imageVector = bottomNavItem.icon,
                                contentDescription = null,
                                tint = selectedIconColor
                            )
                        },
                        label = {
                            // 根据选中状态设置文字样式
                            Text(
                                text = bottomNavItem.title,
                                style = TextStyle(
                                    fontSize = 12.sp, // 设置字体大小
                                    fontWeight = if (currentRoute == bottomNavItem.route) FontWeight.Bold else FontWeight.Normal, // 选中时字体加粗
                                    color = if (currentRoute == bottomNavItem.route) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface // 文字颜色
                                )
                            )
                        },
                        alwaysShowLabel = true, // 始终显示标签
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.secondary,
                            selectedTextColor = MaterialTheme.colorScheme.secondary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            }
        },
    ) {
        MainGraph(
            navController = navController
        )
    }
}
