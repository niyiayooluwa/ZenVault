package com.zenvault.intern.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zenvault.intern.utils.TransferViewModel


@Composable
fun TransferScreen(
    navController: NavController,
    viewModel: TransferViewModel = viewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            ){
               IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBackIosNew,
                        contentDescription = "Back",
                        tint = Color(0xff121212),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Transfer to Bank Account",
                    fontSize = 20.sp,
                    color = Color(0xff121212),
                    fontWeight = FontWeight.Medium
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.White)
            ) {
                RecipientAccount(viewModel)

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF10B982),
                        contentColor = Color.White
                    ),
                    onClick = {navController.navigate("completeTransfer") },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    Text(
                        text = "Transfer",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}


@Composable
fun RecipientAccount(viewModel: TransferViewModel) {
    val accountNumber by viewModel.accountNumber.observeAsState("")
    Column {
        //Text field for entering account number
        OutlinedTextField(
            value = accountNumber,
            onValueChange = {userText ->
                if (userText.length <= 10 && userText.matches(Regex("[0-9]*"))) {
                    viewModel.setAccountNumber(userText)
                }
            },
            label = {
                Text(
                    text = "Enter 10 digits Account Number",
                    color =  Color(0xFF475569)
                )},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF121212),
                unfocusedTextColor = Color(0xFF121212),
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Spacer(Modifier.height(12.dp))

        BankDropdown(viewModel)
    }
}

/**
 * Special bank function that displays suggested banks by observing the value of the account number
 * text filed Value.
 */
@Composable
fun BankDropdown(viewModel: TransferViewModel) {
    val allBanks = remember { generateBankList() }
    val selectedBank by viewModel.selectedBank.observeAsState("")
    // Determine the first digit of the account number
    val firstDigit = viewModel.accountNumber.value?.firstOrNull()?.digitToInt()

    // Get the 2 banks based on the first digit
    val banksToShow = getBanksBasedOnFirstDigit(firstDigit ?: 0, allBanks)
    var isDropdownOpen by remember { mutableStateOf(false) }

    // Dropdown layout
    Column {
        // Text field to show selected bank
        OutlinedTextField(
            value = selectedBank,
            onValueChange = {},
            label = { Text("Select Bank") },
            readOnly = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF121212),
                unfocusedTextColor = Color(0xFF121212),
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            trailingIcon = {
                Icon(
                    Icons.Rounded.KeyboardArrowDown,
                    contentDescription = "Open Dropdown",
                    modifier = Modifier
                        .clickable{isDropdownOpen = !isDropdownOpen}
                        .size(24.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isDropdownOpen = true }
        )

        // Show dropdown if open
        if (isDropdownOpen) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                items(banksToShow) { bank ->
                    Text(
                        color = Color(0xFF121212),
                        text = bank,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                viewModel.setSelectedBank(bank)
                                isDropdownOpen = false
                            }
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

//Function to generate a list of dope sounding banks
fun generateBankList(): List<String> {
    val baseWords = listOf(
        "Zenith", "Harmony", "Pioneer", "Unity", "Apex",
        "Keystone", "Infinity", "Stellar", "Legacy", "Quantum",
        "Horizon", "Regal", "Sovereign", "Nimbus", "Titan",
        "Astral", "Vanguard", "Noble", "Fusion", "Prism"
    )
    val suffixes = listOf("MFB", "Bank", "Digital", "Wallet")

    return baseWords.map { word ->
        val randomSuffix = suffixes.random() // Pick a random suffix
        "$word $randomSuffix"
    }
}

// Function to get banks based on the first digit of the account number
fun getBanksBasedOnFirstDigit(firstDigit: Int, allBanks: List<String>): List<String> {
    // Calculate the start index based on the first digit
    val startIndex = firstDigit * 2
    return allBanks.drop(startIndex).take(2) // Show the next 2 banks
}

