package org.example.geekreward.navigation

import NotificationMainScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.example.geekreward.Routes
import org.example.geekreward.ui.bounty.screen.GeekMainScreen
import org.example.geekreward.ui.geek.screen.BountyMainScreen
import org.example.geekreward.ui.user.screen.UserMainScreen

@Composable
fun MainGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.BOUNTY_MAIN,
    ) {
        composable(Routes.BOUNTY_MAIN) {
            BountyMainScreen()
        }
        composable(Routes.GEEK_MAIN) {
            GeekMainScreen()
        }
        composable(Routes.NOTIFICATIONS_MAIN) {
            NotificationMainScreen()
        }
        composable(Routes.USER_MAIN) {
            UserMainScreen()
        }
    }
}