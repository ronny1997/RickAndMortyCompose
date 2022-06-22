package com.ronny.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ronny.core.navigation.Screen
import com.ronny.presentation.authentication.LoginView
import com.ronny.presentation.home.HomeView
import com.ronny.presentation.planets.PlanetsView

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginView(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeView()
        }
        composable(Screen.Planets.route) {
            PlanetsView()
        }
    }
}