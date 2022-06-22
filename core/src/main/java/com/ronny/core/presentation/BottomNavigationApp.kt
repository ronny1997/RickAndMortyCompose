package com.ronny.core.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ronny.core.navigation.Screen

@Composable
fun BottomNavigationApp(
    navController: NavHostController,
    currentRoute: String?
) {
    val items = listOf(
        Screen.Home,
        Screen.Planets
    )
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = Color.White,
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 8.dp)
            .clip(RoundedCornerShape(18.dp))
    ) {
        val backstackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = backstackEntry?.destination
        items.forEach { item ->

            BottomNavigationItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                alwaysShowLabel = true,
                selected = currentDestination?.hierarchy?.any { item.route == currentRoute } == true,
                onClick = {
                    currentRoute?.let {
                        if (currentRoute != item.route) {
                            navController.navigate(item.route)
                        }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationApp(rememberNavController(), "")
}