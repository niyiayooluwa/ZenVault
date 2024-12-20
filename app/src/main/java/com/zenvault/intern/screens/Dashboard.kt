package com.zenvault.intern.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zenvault.intern.BottomNavigationBar
import com.zenvault.intern.dashboard.Actions
import com.zenvault.intern.dashboard.BalanceSection
import com.zenvault.intern.dashboard.CardAlt
import com.zenvault.intern.dashboard.DailyRefresh
import com.zenvault.intern.dashboard.GreetingSection
import com.zenvault.intern.dashboard.QuickActions
import com.zenvault.intern.dashboard.QuickTransferSection
import com.zenvault.intern.dashboard.Statistics
import com.zenvault.intern.dashboard.TransactionHistory

@Composable
fun Dashboard(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
            padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            GreetingSection()

            val scrollState = rememberScrollState()
            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                BalanceSection()
                CardAlt(navController)
                Actions(navController)
                QuickTransferSection()
                QuickActions()
                TransactionHistory()
                Statistics()
                DailyRefresh()
            }
        }
    }

}