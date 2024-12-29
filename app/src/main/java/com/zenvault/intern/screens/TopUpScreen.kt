package com.zenvault.intern.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun TopUpScreen(
    navController: NavController
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
                    text = "Cards",
                    fontSize = 20.sp,
                    color = Color(0xff121212),
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.White)
            ) {
                //Bank Transfer
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .border(
                            width = 2.dp, // Border around the container
                            color = Color(0xFFDDE4EE), // Border color
                            shape = RoundedCornerShape(12.dp) // Rounded corners for the border
                        )
                        .padding(
                            vertical = 16.dp,
                            horizontal = 16.dp
                        )
                ) {
                    //Bank Transfer with icon row
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            //Bank Icon
                            Box (
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .size(40.dp)
                                    .background(Color(0xFFE9FFF8))
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.home_broken),
                                    contentDescription = "Bank Icon",
                                    tint = Color(0xff121212),
                                    modifier = Modifier
                                        .size(24.dp)
                                        .align(Alignment.Center)
                                )
                            }

                            //Bank Transfer
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                horizontalAlignment = Alignment.Start
                            ){
                                Text(
                                    text = "Bank Transfer",
                                    fontSize = 16.sp,
                                    color = Color(0xff121212),
                                    fontWeight = FontWeight.Medium
                                )

                                Text(
                                    text = "Add money via mobile or internet banking",
                                    fontSize = 12.sp,
                                    color = Color(0xff475569),
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }

                        //Icon
                        Icon(
                            Icons.Rounded.ArrowForwardIos,
                            contentDescription = "Icon",
                            tint = Color(0xff121212),
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    LineUI()

                    //Actual account number column
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        //Text column for account number and label
                        Column (
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "ZenVault Wallet Account Number",
                                fontSize = 12.sp,
                                color = Color(0xff475569),
                                fontWeight = FontWeight.Normal
                            )

                            Text(
                                text = "123 4567 890",
                                fontSize = 32.sp,
                                color = Color(0xff121212),
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp) // Spacing between buttons
                        ) {
                            // Copy Account Number button
                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .weight(1f), // Equal width for buttons
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF10b982) // Green background color
                                )
                            ) {
                                Text(
                                    text = "Copy", // Button text
                                    color = Color.White, // Text color
                                    fontSize = 12.sp // Font size
                                )
                            }

                            //Share button
                            Button(
                                onClick = {}, // Action for sharing
                                modifier = Modifier
                                    .weight(1f), // Equal width for buttons
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFE1f5ea) // Colored Background
                                )
                            ) {
                                Text(
                                    text = "Share Details", // Button text
                                    color = Color(0xFF10b982), // Text color
                                    fontSize = 12.sp // Font size
                                )
                            }
                        }
                    }
                }

                //Scan my QR code
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .border(
                            width = 2.dp, // Border around the container
                            color = Color(0xFFDDE4EE), // Border color
                            shape = RoundedCornerShape(12.dp) // Rounded corners for the border
                        )
                        .padding(
                            vertical = 16.dp,
                            horizontal = 16.dp
                        )
                ) {
                    //Qr code with icon row
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            //Bank Icon
                            Box (
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .size(40.dp)
                                    .background(Color(0xFFE9FFF8))
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.qr_code),
                                    contentDescription = "Bank Icon",
                                    tint = Color(0xff121212),
                                    modifier = Modifier
                                        .size(24.dp)
                                        .align(Alignment.Center)
                                )
                            }

                            //Qr text
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp),
                                horizontalAlignment = Alignment.Start
                            ){
                                Text(
                                    text = "Scan my QR Code",
                                    fontSize = 16.sp,
                                    color = Color(0xff121212),
                                    fontWeight = FontWeight.Medium
                                )

                                Text(
                                    text = "Show my QR code to receive money",
                                    fontSize = 12.sp,
                                    color = Color(0xff475569),
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }

                        //Icon
                        Icon(
                            Icons.Rounded.ArrowForwardIos,
                            contentDescription = "Icon",
                            tint = Color(0xff121212),
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    Image(
                        painter = painterResource(R.drawable.untitled_1),
                        contentDescription = "QR Code",
                        modifier = Modifier
                            .size(200.dp)

                    )
                }
            }
        }
    }
}
