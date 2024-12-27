package com.zenvault.intern

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zenvault.intern.data.card
import com.zenvault.intern.screens.BudgetScreen
import com.zenvault.intern.screens.CardDetails
import com.zenvault.intern.screens.CardsScreen
import com.zenvault.intern.screens.Dashboard
import com.zenvault.intern.screens.ExchangeScreen
import com.zenvault.intern.screens.InvestScreen
import com.zenvault.intern.screens.MoreScreen
import com.zenvault.intern.screens.SaveScreen
import com.zenvault.intern.screens.TopUpScreen
import com.zenvault.intern.screens.TransferCard
import com.zenvault.intern.screens.TransferScreen
import com.zenvault.intern.utils.CardViewModel
import com.zenvault.intern.utils.TransferViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    val cardViewModel: CardViewModel = viewModel()
    val transferViewModel: TransferViewModel = viewModel()

    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { Dashboard(navController) }
        composable("save") { SaveScreen(navController) }
        composable("invest") { InvestScreen(navController) }
        composable("budget") { BudgetScreen(navController) }
        composable("more") { MoreScreen(navController) }
        composable("transfer") { TransferScreen(navController, transferViewModel) }
        composable("topup") { TopUpScreen(navController) }
        composable("exchange") { ExchangeScreen(navController) }
        composable("cards") { CardsScreen(cardViewModel, navController) }
        composable("details") { CardDetails(cardViewModel, navController)}
        composable("completeTransfer") { TransferCard(navController, transferViewModel, card) }
    }
}
