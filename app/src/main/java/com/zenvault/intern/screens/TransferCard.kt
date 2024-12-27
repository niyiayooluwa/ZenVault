package com.zenvault.intern.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zenvault.intern.R
import com.zenvault.intern.dashboard.LineUI
import com.zenvault.intern.data.Card
import com.zenvault.intern.utils.CardOperations.withdraw
import com.zenvault.intern.utils.TransferViewModel
import com.zenvault.intern.utils.formatBalance

@Composable
fun TransferCard(
    navController: NavController,
    viewModel: TransferViewModel = viewModel(),
    cards: List<Card> // Pass the list of cards to this composable
) {
    // ViewModel observers
    val accountNumber by viewModel.accountNumber.observeAsState("")
    val selectedBank by viewModel.selectedBank.observeAsState("")
    val name by viewModel.name.observeAsState("")
    val amount by viewModel.amount.observeAsState("")

    // State for the currently selected card
    val defaultCard = cards[0] // Default to the first card
    var selectedCard by remember { mutableStateOf(defaultCard) }
    var expanded by remember { mutableStateOf(false) }
    var dialog by remember { mutableStateOf(false)}


    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            //Top app bar
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            ) {
                //Back button
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

                Text(
                    text = "Transfer",
                    fontSize = 20.sp,
                    color = Color(0xff121212),
                    fontWeight = FontWeight.Medium
                )

                //Clicking this icon should take us to the transfer history which is to be implemented later
                Icon(
                    Icons.Rounded.History,
                    contentDescription = "History",
                    tint = Color(0xff10b982),
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                /**
                 *  Transfer Information, na here e dey. Displays info about recipient and card to
                 *  be used for the transfer
                 */
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    // Outer column containing all UI elements
                    Column(
                        modifier = Modifier
                            .border(
                                width = 2.dp, // Border around the container
                                color = Color(0xFF475569), // Border color
                                shape = RoundedCornerShape(12.dp) // Rounded corners for the border
                            )
                            .background(Color.White) // Background color of the container
                            .clip(RoundedCornerShape(12.dp)) // Rounded corners for the container itself
                            .padding(horizontal = 12.dp) // Padding inside the container
                    ) {
                        // Recipient Information Section
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp) // Padding around the recipient information
                        ) {
                            Text(
                                text = "Send To", // Title for recipient section
                                fontSize = 16.sp,
                                color = Color(0xFF121212),
                                fontWeight = FontWeight.Medium
                            )

                            Spacer(Modifier.height(4.dp)) // Spacer between title and content

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                // Image and Recipient Details
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    // Recipient image
                                    Image(
                                        painter = painterResource(R.drawable.frame_7),
                                        contentDescription = "User Pic", // Description for accessibility
                                        modifier = Modifier
                                            .size(50.dp) // Set size of the image
                                            .clip(CircleShape) // Make the image circular
                                    )

                                    Spacer(Modifier.width(16.dp)) // Spacer between image and text

                                    // Recipient name and account details
                                    Column {
                                        Text(
                                            text = name, // Display recipient's name
                                            fontSize = 12.sp,
                                            color = Color(0xFF121212),
                                            fontWeight = FontWeight.Medium
                                        )

                                        Row {
                                            // Account number
                                            Text(
                                                text = accountNumber,
                                                fontSize = 12.sp,
                                                color = Color(0xFF475569),
                                            )

                                            Spacer(Modifier.height(2.dp)) // Spacer between account number and bank name

                                            // Selected bank name
                                            Text(
                                                text = selectedBank,
                                                fontSize = 12.sp,
                                                color = Color(0xFF475569)
                                            )
                                        }
                                    }
                                }

                                // Change button
                                Box(
                                    modifier = Modifier
                                        .width(80.dp)
                                        .height(32.dp)
                                        .clickable { navController.popBackStack() } // Action when clicked
                                        .border(
                                            width = 1.dp,
                                            color = Color(0xFFDDE4EE),
                                            shape = RoundedCornerShape(8.dp) // Rounded corners for the button
                                        )
                                ) {
                                    Text(
                                        text = "Change", // Text on the button
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color(0xFF475569),
                                        modifier = Modifier.align(Alignment.Center) // Center the text inside the box
                                    )
                                }
                            }
                        }

                        Spacer(Modifier.height(4.dp)) // Spacer between sections

                        LineUI(isDashed = false) // Line separator

                        Spacer(Modifier.height(4.dp)) // Spacer after the line separator

                        // Selected Card Information Section
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp) // Padding around the selected card section
                        ) {
                            Text(
                                text = "From", // Title for the card section
                                fontSize = 16.sp,
                                color = Color(0xFF121212),
                                fontWeight = FontWeight.Medium
                            )

                            Spacer(Modifier.height(4.dp)) // Spacer between title and content

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                // Card details
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    // Display card image
                                    Image(
                                        painter = painterResource(id = miniCards[selectedCard.imageIndex]),
                                        contentDescription = "Card Image",
                                        modifier = Modifier.size(50.dp) // Set size of the image
                                    )

                                    Spacer(Modifier.width(16.dp)) // Spacer between card image and text

                                    // Display card name and balance
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Text(
                                            text = selectedCard.cardName, // Display selected card's name
                                            fontSize = 12.sp,
                                            color = Color(0xFF121212),
                                            fontWeight = FontWeight.Medium
                                        )

                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "Balance: ", // Label for balance
                                                fontSize = 12.sp,
                                                color = Color(0xFF475569),
                                            )

                                            // Format and display the card's balance
                                            selectedCard.getRawBalance()?.let {
                                                Text(
                                                    text = formatBalance(it), // Format the balance as currency
                                                    fontSize = 12.sp,
                                                    color = Color(0xFF475569)
                                                )
                                            }
                                        }
                                    }
                                }

                                // Change button for the selected card
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .width(80.dp)
                                            .height(32.dp)
                                            .border(
                                                width = 1.dp,
                                                color = Color(0xFFDDE4EE),
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            .background(Color.White)
                                    ) {
                                        Text(
                                            text = "Change", // Text for the button
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color(0xFF475569),
                                            modifier = Modifier
                                                .align(Alignment.Center) // Center the text inside the box
                                                .clickable {expanded = true} // Toggle the dropdown when clicked
                                        )
                                    }
                                }
                            }
                        }

                        // Logic for displaying the drop-down list of available cards
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // Display the drop-down list if expanded
                            if (expanded) {
                                LazyColumn(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.White)
                                        .padding(8.dp) // Padding inside the list
                                ) {
                                    // Exclude the last card from the list
                                    items(cards.dropLast(1).withIndex().toList()) { (index, card) ->
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clickable {
                                                    selectedCard = card // Set selected card
                                                    expanded = false // Close the drop-down
                                                }
                                                .padding(8.dp),
                                        ) {
                                            // Display the mini card image and card name
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                            ) {
                                                Image(
                                                    painter = painterResource(miniCards[index]),
                                                    contentDescription = "Mini Card Image",
                                                    modifier = Modifier.size(35.dp) // Set size of the image
                                                )
                                                Spacer(Modifier.width(8.dp)) // Spacer between image and text

                                                Text(
                                                    text = card.cardName, // Display card name
                                                    fontSize = 16.sp,
                                                    color = Color(0xFF121212),
                                                    fontWeight = FontWeight.Medium
                                                )
                                            }

                                            // Display the balance of the card
                                            card.getRawBalance()?.let {
                                                Text(
                                                    text = formatBalance(it), // Format the balance as currency
                                                    fontSize = 14.sp,
                                                    color = Color(0xFF475569)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(Modifier.height(24.dp))

                Column(
                    // Arrange children vertically with spacing of 8.dp between them
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        // Fill the available width and height of the parent
                        .fillMaxWidth()
                        .fillMaxHeight()
                        // Clip corners with a rounded shape of 16.dp
                        .clip(RoundedCornerShape(16.dp))
                        // Set the background color to light gray
                        .background(Color(0xFFDFE1E7))
                        // Add padding at the top of 8.dp
                        .padding(top = 8.dp)
                ) {
                    Row(
                        // Center content horizontally and vertically within the row
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth() // Row spans the full width of the parent
                    ) {
                        Icon(
                            // Use a rounded info icon to display additional information
                            Icons.Rounded.Info,
                            contentDescription = "Info", // Accessibility description for the icon
                            tint = Color(0xFF475569), // Set the icon color to a dark gray-blue
                            modifier = Modifier.size(18.dp) // Set the icon size to 18.dp
                        )

                        Spacer(Modifier.width(4.dp)) // Add a small space of 4.dp between the icon and text

                        Text(
                            text = "Double-check details before proceeding", // Instructional text
                            color = Color(0xFF475569), // Text color matches the icon color
                            fontSize = 14.sp, // Font size for the text
                            fontWeight = FontWeight.Medium // Medium weight for emphasis
                        )
                    }

                    Column(
                        modifier = Modifier
                            // Column fills the remaining available space
                            .fillMaxSize()
                            // Clip corners with a rounded shape of 16.dp
                            .clip(RoundedCornerShape(16.dp))
                            // Set the background color to white
                            .background(Color.White)
                    ) {
                        Column(
                            // Space children within the column by 12.dp vertically
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier
                                // Add horizontal padding of 16.dp and vertical padding of 12.dp
                                .padding(horizontal = 16.dp, vertical = 12.dp)
                                .fillMaxSize() // Column spans the available space
                        ) {
                            // Input field for entering the amount
                            AmountInputField(viewModel)

                            // Horizontal divider line
                            LineUI(false)

                            // Confirm button for submitting the transaction
                            Button(
                                onClick = {
                                    // Perform withdrawal using the selected card and entered amount
                                    withdraw(
                                        cardNumber = selectedCard.cardNumber,
                                        amount = amount.toDoubleOrNull() ?: 0.0
                                    )
                                    // Toggle the visibility of the dialog
                                    dialog = true
                                },
                                enabled = amount.toDoubleOrNull() != null, // Enable button only if amount is valid
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF10B982) // Set the button color to green
                                ),
                                shape = RoundedCornerShape(12.dp), // Apply rounded corners to the button
                                modifier = Modifier
                                    .fillMaxWidth() // Button spans the full width of the parent
                                    .height(45.dp) // Set the button height to 45.dp
                            ) {
                                Text(
                                    text = "Confirm", // Button label
                                    fontSize = 14.sp, // Font size for the label
                                    fontWeight = FontWeight.Medium // Medium weight for emphasis
                                )
                            }
                        }
                    }
                }
            }

            TransactionConfirmationDialog(
                showDialog = dialog,
                onDismiss = { dialog = false},
                recipientName = name,
                accountName = selectedCard.cardName,
                paymentAmount = amount,
                transactionDate = "27/12/2024",
                transactionId = "#A78IXL01GG"
            )
        }
    }
}




//Special Row
@Composable
fun AmountInputField(viewModel: TransferViewModel) {
    val amount by viewModel.amount.observeAsState("")
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Amount",
            color = Color(0xFF475569), // Grayish color
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )

        //Input text field is here

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "₦",
                color = Color(0xFF475569), // Grayish color
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.width(4.dp))

            TextField(
                value = amount,
                onValueChange = {money -> viewModel.setAmount(money)},
                placeholder = {
                    Text(
                        text = "0",
                        color = Color(0xFF475569),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color(0xFF121212),
                    unfocusedTextColor = Color(0xFF121212),
                    focusedBorderColor = Color(0xFF10B982), // Green border
                    unfocusedBorderColor = Color(0xFFE0E0E0), // Light gray border
                    cursorColor = Color(0xFF10B982) // Green cursor
                ),
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),

                modifier = Modifier.width(150.dp)
            )
        }
    }
}




@Composable
fun TransactionConfirmationDialog(
    showDialog: Boolean, // Controls visibility of the dialog
    onDismiss: () -> Unit, // Callback for dismissing the dialog
    recipientName: String, // Name of the recipient
    accountName: String, // Name of the account used for payment
    paymentAmount: String, // Payment amount to be displayed
    transactionDate: String, // Date of the transaction
    transactionId: String // Unique identifier for the transaction
) {
    // Check if the dialog should be displayed
    if (showDialog) {
        Dialog(
            onDismissRequest = onDismiss, // Triggered when the user dismisses the dialog
            properties = DialogProperties(usePlatformDefaultWidth = false) // Custom dialog width
        ) {
            // Dialog background and padding setup
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)) // Rounded corners
                    .background(Color.White) // White background for the dialog
                    .padding(16.dp) // Padding around the dialog content
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally // Center alignment for elements
                ) {
                    // Close button positioned at the top-right
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        contentAlignment = Alignment.CenterEnd // Align close button to the right
                    ) {
                        IconButton(onClick = onDismiss) {
                            Icon(
                                imageVector = Icons.Default.Close, // Close icon
                                contentDescription = "Close", // Accessibility description
                                tint = Color.Gray // Icon color
                            )
                        }
                    }

                    // Success Icon and Text Section
                    Image(
                        painter = painterResource(R.drawable.pay), // Success image resource
                        contentDescription = "Success", // Accessibility description
                        modifier = Modifier.size(150.dp) // Image size
                    )
                    Spacer(modifier = Modifier.height(8.dp)) // Spacing between elements

                    Text(
                        text = "Transfer Success!", // Success message
                        fontWeight = FontWeight.Bold, // Bold text
                        fontSize = 18.sp, // Font size
                        color = Color(0xFF121212) // Text color
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Transfer to $recipientName has been successfully completed", // Detailed success message
                        fontSize = 14.sp, // Font size
                        color = Color(0xFF475569), // Text color
                        textAlign = TextAlign.Center // Center-aligned text
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Card Payment Details Section
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Card Payment Header
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp), // Spacing between elements
                            horizontalAlignment = Alignment.Start, // Align text to the start
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Card Payment", // Header text
                                fontSize = 12.sp, // Font size
                                color = Color(0xFF475569), // Text color
                                fontWeight = FontWeight.Medium // Medium weight text
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween // Space elements equally
                            ) {
                                Text(
                                    text = accountName, // Account name
                                    fontSize = 16.sp, // Font size
                                    color = Color(0xFF121212), // Text color
                                    fontWeight = FontWeight.SemiBold // Semi-bold text
                                )

                                Text(
                                    text = paymentAmount, // Placeholder for amount
                                    fontSize = 16.sp, // Font size
                                    color = Color(0xFF121212), // Text color
                                    fontWeight = FontWeight.Medium // Medium weight text
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))
                        LineUI(false) // Divider line
                        Spacer(modifier = Modifier.height(12.dp))

                        // Transaction Detail Section
                        Column(
                            horizontalAlignment = Alignment.Start, // Align text to the start
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Transaction Detail", // Header text
                                fontSize = 12.sp, // Font size
                                color = Color(0xFF475569), // Text color
                                fontWeight = FontWeight.Medium // Medium weight text
                            )

                            Spacer(Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween // Space elements equally
                            ) {
                                Text(
                                    text = "Amount", // Label for amount
                                    fontSize = 16.sp, // Font size
                                    color = Color(0xFF121212), // Text color
                                    fontWeight = FontWeight.SemiBold // Semi-bold text
                                )

                                Text(
                                    text = paymentAmount, // Actual payment amount
                                    fontSize = 16.sp, // Font size
                                    color = Color(0xFF121212), // Text color
                                    fontWeight = FontWeight.Medium // Medium weight text
                                )
                            }

                            Spacer(Modifier.height(12.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween // Space elements equally
                            ) {
                                Text(
                                    text = "Transaction Date", // Label for transaction date
                                    fontSize = 16.sp, // Font size
                                    color = Color(0xFF121212), // Text color
                                    fontWeight = FontWeight.SemiBold // Semi-bold text
                                )

                                Text(
                                    text = transactionDate, // Actual transaction date
                                    fontSize = 16.sp, // Font size
                                    color = Color(0xFF121212), // Text color
                                    fontWeight = FontWeight.Medium // Medium weight text
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Transaction ID Section
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween, // Space elements equally
                        verticalAlignment = Alignment.CenterVertically // Center elements vertically
                    ) {
                        Column {
                            Text(
                                text = "Transaction ID", // Label for transaction ID
                                fontSize = 12.sp, // Font size
                                color = Color(0xFF475569), // Text color
                                fontWeight = FontWeight.Medium // Medium weight text
                            )

                            Spacer(Modifier.height(8.dp))

                            Text(
                                text = transactionId, // Actual transaction ID
                                fontSize = 20.sp, // Font size
                                color = Color(0xFF121212), // Text color
                                fontWeight = FontWeight.Bold // Bold text
                            )
                        }

                        // Copy Button
                        Row {
                            Text(
                                text = "Copy", // Copy button text
                                fontSize = 16.sp, // Font size
                                color = Color(0xFF475569) // Text color
                            )

                            Spacer(Modifier.width(3.dp))

                            Icon(
                                Icons.Rounded.ContentCopy, // Copy icon
                                contentDescription = "Copy", // Accessibility description
                                tint = Color(0xFF475569), // Icon color
                                modifier = Modifier.size(24.dp) // Icon size
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Buttons for Download Receipt and Exit
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp) // Spacing between buttons
                    ) {
                        // Download Receipt button
                        Button(
                            onClick = { }, // Action for downloading receipt
                            modifier = Modifier.weight(1f), // Equal width for buttons
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF10b982) // Green background color
                            )
                        ) {
                            Text(
                                text = "Download Receipt", // Button text
                                color = Color.White, // Text color
                                fontSize = 12.sp // Font size
                            )
                        }

                        // Exit button
                        Button(
                            onClick = {}, // Action for exiting
                            modifier = Modifier
                                .weight(1f) // Equal width for buttons
                                .border(
                                    width = 2.dp, // Border width
                                    color = Color(0xFF10b982), // Border color
                                    shape = RoundedCornerShape(24.dp) // Rounded corners for button
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent // Transparent background
                            )
                        ) {
                            Text(
                                text = "Exit", // Button text
                                color = Color(0xFF10b982), // Text color
                                fontSize = 12.sp // Font size
                            )
                        }
                    }
                }
            }
        }
    }
}



val miniCards = listOf(
    R.drawable.mini,
    R.drawable.red_mini,
    R.drawable.purple_mini
)



