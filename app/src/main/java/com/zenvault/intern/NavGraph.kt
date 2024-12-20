package com.zenvault.intern

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zenvault.intern.screens.BudgetScreen
import com.zenvault.intern.screens.CardDetails
import com.zenvault.intern.screens.CardsScreen
import com.zenvault.intern.screens.Dashboard
import com.zenvault.intern.screens.ExchangeScreen
import com.zenvault.intern.screens.InvestScreen
import com.zenvault.intern.screens.MoreScreen
import com.zenvault.intern.screens.SaveScreen
import com.zenvault.intern.screens.TopUpScreen
import com.zenvault.intern.screens.TransferScreen
import com.zenvault.intern.utils.CardViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    val cardViewModel: CardViewModel = viewModel()

    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { Dashboard(navController) }
        composable("save") { SaveScreen(navController) }
        composable("invest") { InvestScreen(navController) }
        composable("budget") { BudgetScreen(navController) }
        composable("more") { MoreScreen(navController) }
        composable("transfer") { TransferScreen(navController) }
        composable("topup") { TopUpScreen(navController) }
        composable("exchange") { ExchangeScreen(navController) }
        composable("cards") {
            CardsScreen(viewModel = cardViewModel, navController = navController)
        }
        composable("details") {
            CardDetails(viewModel = cardViewModel, navController = navController)
        }

    }
}
