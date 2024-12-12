package com.zenvault.intern.home

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zenvault.intern.R

@Preview(showBackground = true)
@Composable
fun DailyRefresh() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = Color(0xFFDDE4EE),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(
                top = 28.dp,
                bottom = 16.dp,
                start = 36.dp,
                end = 36.dp
            )
    ){
        Text (
            text = "Daily Refresh",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF121212),
            modifier = Modifier.align(Alignment.Start)
        )


        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
        ){
            //Quote of the Day
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Row(modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF10B982))){}

                Box(
                    modifier = Modifier
                        .width(314.dp)
                        .height(202.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.message_1),
                        contentDescription = "Card Image",
                        modifier = Modifier.fillMaxSize()

                    )

                    Column (
                        modifier = Modifier
                            .padding(
                                top = 24.dp,
                                start = 12.dp
                            )
                            .align(Alignment.TopStart)
                    ) {
                        Text(
                            text = "Quote of the Day",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Investment advice #10",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White

                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        Text(
                            text =
                            """
                             The best investment you can make
                             is in yourself
                         """.trimIndent(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }
            }



            //Guided Session
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Row(modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF10B982), CircleShape)){}

                Box(
                    modifier = Modifier
                        .width(314.dp)
                        .height(100.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.message_2),
                        contentDescription = "Card Image",
                        modifier = Modifier.fillMaxSize()

                    )

                    Column (
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(
                                top = 12.dp,
                                start = 12.dp,
                                end = 8.dp
                    )
                        .align(Alignment.TopStart)
                    ) {
                        Text(
                            text = "Guided Session",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )

                        Text(
                            text = "Setting Financial Goals: Day 2",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White

                        )

                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Outlined.AccessTime,
                                contentDescription = "Information",
                                modifier = Modifier.size(16.dp),
                                tint = Color.White
                            )

                            Text(
                                text = "2-5 min",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }

    }
}