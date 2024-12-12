package com.zenvault.intern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zenvault.intern.home.BalanceSection
import com.zenvault.intern.home.CardAlt
import com.zenvault.intern.home.DailyRefresh
import com.zenvault.intern.home.GreetingSection
import com.zenvault.intern.home.QuickActions
import com.zenvault.intern.home.QuickTransferSection
import com.zenvault.intern.home.Statistics
import com.zenvault.intern.home.TransactionHistory
import com.zenvault.intern.ui.theme.ZenVaultTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZenVaultTheme {
                SetBackgroundColor(MaterialTheme.colorScheme.background)
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    HomeScreen()
                }
            }
        }
    }
}


@Composable
private fun SetBackgroundColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.run{
            setSystemBarsColor(
                color = color
            )
        }
    }
}


@Preview
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
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
                CardAlt()
                QuickTransferSection()
                QuickActions()
                TransactionHistory()
                Statistics()
                DailyRefresh()
            }
        }
    }

}




