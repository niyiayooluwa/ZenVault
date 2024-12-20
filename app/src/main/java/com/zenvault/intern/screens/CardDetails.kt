package com.zenvault.intern.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.NavigateNext
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.zenvault.intern.R
import com.zenvault.intern.dashboard.LineUI
import com.zenvault.intern.data.Card
import com.zenvault.intern.utils.CardItem
import com.zenvault.intern.utils.CardSize
import com.zenvault.intern.utils.CardViewModel
import com.zenvault.intern.utils.formatBalance

@Composable
fun CardDetails(
    viewModel: CardViewModel,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        val card by viewModel.selectedCard.observeAsState()
        var showCard by remember { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
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

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Cards",
                    fontSize = 20.sp,
                    color = Color(0xff121212),
                    fontWeight = FontWeight.Bold
                )
            }

            //
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(380.dp)
                    .height(320.dp)
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            ){
                card?.let { DynamicBoxLayout(showCard, it) }
            }

            //Button that shows the details of the card when clicked
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF10B982),
                    contentColor = Color.White
                ),
                onClick = { showCard = !showCard },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(150.dp)
                    .height(45.dp)
                    .align(Alignment.CenterHorizontally)
                ) {
                Text(
                    text = if (showCard) "Show Details" else "Hide Details",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                    )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight()

            ){
                //Manage Transaction Pin
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painter = painterResource(R.drawable.password),
                            contentDescription = "Password",
                            modifier = Modifier.size(32.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = "Manage Transaction Pin",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xff121212)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Customize and modify transaction pin options",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xff7f7f7f)
                            )
                        }
                    }

                    Icon(
                        Icons.AutoMirrored.Rounded.NavigateNext,
                        contentDescription = "Arrow",
                        modifier = Modifier.size(24.dp)
                    )
                }

                //Spacer(modifier = Modifier.height(24.dp))

                //Manage subscriptions
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painter = painterResource(R.drawable.shop),
                            contentDescription = "Password",
                            modifier = Modifier.size(32.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = "Manage Subscriptions",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xff121212)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Manage subscriptions to your card",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xff7f7f7f)
                            )
                        }
                    }

                    Icon(
                        Icons.AutoMirrored.Rounded.NavigateNext,
                        contentDescription = "Arrow",
                        modifier = Modifier.size(24.dp)
                    )
                }

                //Spacer(modifier = Modifier.height(24.dp))

                //Card limits
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painter = painterResource(R.drawable.speed),
                            contentDescription = "Password",
                            modifier = Modifier.size(32.dp)
                        )

                        Spacer(modifier = Modifier.width(24.dp))

                        Column {
                            Text(
                                text = "Manage Card Limits",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xff121212)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Change current card limits",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xff7f7f7f)
                            )
                        }
                    }

                    Icon(
                        Icons.AutoMirrored.Rounded.NavigateNext,
                        contentDescription = "Arrow",
                        modifier = Modifier.size(24.dp)
                    )
                }

                //Spacer(modifier = Modifier.height(24.dp))

                //Block card
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painter = painterResource(R.drawable.block),
                            contentDescription = "block",
                            modifier = Modifier.size(32.dp),
                            tint = Color.Red
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = "Block Card",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xff121212)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Temporarily deactivate your card",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xff7f7f7f)
                            )
                        }
                    }

                    Icon(
                        Icons.AutoMirrored.Rounded.NavigateNext,
                        contentDescription = "Arrow",
                        modifier = Modifier.size(24.dp)
                    )
                }

                //Spacer(modifier = Modifier.height(24.dp))

                //Delete card
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painter = painterResource(R.drawable.cancel_circle),
                            contentDescription = "block",
                            modifier = Modifier.size(32.dp),
                            tint = Color.Red
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = "Delete Card",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xff121212)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Permanently disconnect your card",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xff7f7f7f)
                            )
                        }
                    }

                    Icon(
                        Icons.AutoMirrored.Rounded.NavigateNext,
                        contentDescription = "Arrow",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}



@Composable
fun DynamicBoxLayout(showCard: Boolean, card: Card) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ){
        if (showCard) {
            CardItem(card = card, cardSize = CardSize.Big)
        } else {
            Details(card)
        }
    }
}


@Composable
fun Details(card: Card) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .padding(
                horizontal = 20.dp,
                vertical = 8.dp
            )
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                painter = painterResource(id =
                when (card.imageIndex) {
                    0 -> R.drawable.mini
                    1 -> R.drawable.red_mini
                    else -> R.drawable.purple_mini
                }),
                contentDescription = "Card Type",
                modifier = Modifier
                    .width(76.dp)
                    .height(49.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column{
                Text(
                    text = card.cardName,
                    fontSize = 12.sp,
                    color = Color(0xFF64748B),
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(4.dp))

                card.getRawBalance()?.let {
                Text(
                    text = formatBalance(it),
                    fontSize = 12.sp,
                    color = Color(0xFF121212),
                    fontWeight = FontWeight.SemiBold
                )}
            }
        }

        LineUI(false)

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ){
            //Card Name
            Column{
                Text(
                    text = "CARD NAME",
                    fontSize = 14.sp,
                    color = Color(0xFF64748B),
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Cillian Majekodunmi",
                    fontSize = 16.sp,
                    color = Color(0xFF121212),
                    fontWeight = FontWeight.Medium
                )
            }

            //Card Number
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                Column {
                    Text(
                        text = "CARD NUMBER",
                        fontSize = 14.sp,
                        color = Color(0xFF64748B),
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = card.cardNumberLong,
                        fontSize = 16.sp,
                        color = Color(0xFF121212),
                        fontWeight = FontWeight.Medium
                    )
                }


                //Copy
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(
                            vertical = 14.dp,
                            horizontal = 12.dp
                        )
                ) {
                    Icon(
                        Icons.Outlined.ContentCopy,
                        contentDescription = "Copy",
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Copy",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp

                    )
                }
            }


            //Card Exp Date and CVV
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                //Exp Date
                Column {
                    Text(
                        text = "EXP DATE",
                        fontSize = 14.sp,
                        color = Color(0xFF64748B),
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = card.cardExpDate,
                        fontSize = 16.sp,
                        color = Color(0xFF121212),
                        fontWeight = FontWeight.Medium
                    )
                }

                //CVV
                Column {
                    Text(
                        text = "CVV (SECURITY CODE)",
                        fontSize = 14.sp,
                        color = Color(0xFF64748B),
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = card.cardCvv.toString(),
                        fontSize = 16.sp,
                        color = Color(0xFF121212),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

