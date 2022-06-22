package com.ronny.presentation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ronny.core.navigation.Screen
import com.ronny.core.presentation.BottomNavigationApp
import com.ronny.core.presentation.ui.theme.ExampleTheme

@Composable
fun RickAndMortyApp() {
    ExampleTheme {
        val navController = rememberNavController()
        val backstackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = backstackEntry.value?.destination?.route

        Scaffold(
            bottomBar = {
                currentRoute?.let { route ->
                    if (route != Screen.Login.route) {
                        BottomNavigationApp(
                            navController = navController,
                            currentRoute = currentRoute
                        )
                    }
                }
            }
        ) {
            NavigationHost(navController = navController)
        }
    }
}
