package com.ronny.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(var route: String, var icon: ImageVector, var title: String){
    object Login : Screen("LoginScreen", Icons.Filled.Home, "Login")
    object Home : Screen("HomeScreen", Icons.Filled.Home, "Home")
    object Planets : Screen("Planets", Icons.Filled.Place, "Place")
}
