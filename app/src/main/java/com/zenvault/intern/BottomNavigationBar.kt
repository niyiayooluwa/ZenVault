package com.zenvault.intern

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zenvault.intern.data.BottomNavigation

val items = listOf(
    BottomNavigation(
        title = "Home",
        route = "dashboard", // Add route for navigation
        icon = R.drawable.dashboard
    ),
    BottomNavigation(
        title = "Save",
        route = "save", // Add route for navigation
        icon = R.drawable.savings
    ),
    BottomNavigation(
        title = "Invest",
        route = "invest", // Add route for navigation
        icon = R.drawable.invest_rounded
    ),
    BottomNavigation(
        title = "Budget",
        route = "budget", // Add route for navigation
        icon = R.drawable.wallet
    ),
    BottomNavigation(
        title = "More",
        route = "more", // Add route for navigation
        icon = R.drawable.menu_broken
    ),
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    // Observe the current navigation backstack entry
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        Row(
            modifier = Modifier
                .background(Color.White)
        ) {
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    // Highlight based on current route
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
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title,
                            tint = if (currentRoute == item.route) Color(0xFF10b892) else Color(0xFF121212)
                        )
                    },
                    /*label = {
                        Text(
                            text = item.title,
                            color = if (currentRoute == item.route) Color(0xFF10b892) else Color.Gray
                        )
                    }*/
                )
            }
        }
    }
}