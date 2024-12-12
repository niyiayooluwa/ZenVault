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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.zenvault.intern.data.BottomNavigation

val items = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),

    BottomNavigation(
        title = "Save",
        icon = Icons.Rounded.Savings
    ),

    BottomNavigation(
        title = "Invest",
        icon = Icons.Rounded.BarChart
    ),

    BottomNavigation(
        title = "Budget",
        icon = Icons.Rounded.AccountBalanceWallet
    ),

    BottomNavigation(
        title = "More",
        icon = Icons.Rounded.Menu
    ),
)




@Preview
@Composable
fun BottomNavigationBar() {
    NavigationBar {
        Row(
            modifier = Modifier.background(Color.White)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = Color(0xFF10b892)
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = Color.Gray
                        )
                    }
                )
            }
        }
    }
}

