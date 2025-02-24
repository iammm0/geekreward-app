package org.example.geekreward

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBusiness
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.SettingsAccessibility
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    Geek(Routes.GEEK_MAIN, Icons.Outlined.Person, "极客"),
    Bounty(Routes.BOUNTY_MAIN, Icons.Outlined.AddBusiness, "悬赏令"),
    Notification(Routes.NOTIFICATIONS_MAIN, Icons.Outlined.Notifications, "消息"),
    User(Routes.USER_MAIN, Icons.Outlined.SettingsAccessibility, "用户")
}