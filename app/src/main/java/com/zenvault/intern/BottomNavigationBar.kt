package com.zenvault.intern

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.BarChart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Savings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zenvault.intern.data.BottomNavigation

val items = listOf(
    BottomNavigation(
        title = "Home",
        route = "dashboard", // Add route for navigation
        icon = Icons.Rounded.Home
    ),
    BottomNavigation(
        title = "Save",
        route = "save", // Add route for navigation
        icon = Icons.Rounded.Savings
    ),
    BottomNavigation(
        title = "Invest",
        route = "invest", // Add route for navigation
        icon = Icons.Rounded.BarChart
    ),
    BottomNavigation(
        title = "Budget",
        route = "budget", // Add route for navigation
        icon = Icons.Rounded.AccountBalanceWallet
    ),
    BottomNavigation(
        title = "More",
        route = "more", // Add route for navigation
        icon = Icons.Rounded.Menu
    ),
)


@Composable
fun BottomNavigationBar(navController: NavController) {
    // Observe the current navigation backstack entry
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        Row(
            modifier = Modifier.background(Color.White)
        ) {
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route, // Highlight based on current route
                    onClick = {
                        // Navigate to the clicked route
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true // Avoid duplicate destinations in backstack
                                restoreState = true // Restore previous state of the destination
                            }
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = if (currentRoute == item.route) Color(0xFF10b892) else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = if (currentRoute == item.route) Color(0xFF10b892) else Color.Gray
                        )
                    }
                )
            }
        }
    }
}
