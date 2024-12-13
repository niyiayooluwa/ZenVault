package com.zenvault.intern

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zenvault.intern.screens.BudgetScreen
import com.zenvault.intern.screens.CardsScreen
import com.zenvault.intern.screens.Dashboard
import com.zenvault.intern.screens.InvestScreen
import com.zenvault.intern.screens.MoreScreen
import com.zenvault.intern.screens.SaveScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { Dashboard(navController) }
        composable("cards") { CardsScreen() }
        composable("save") { SaveScreen(navController) }
        composable("invest") { InvestScreen(navController) }
        composable("budget") { BudgetScreen(navController) }
        composable("more") { MoreScreen(navController) }
    }
}
