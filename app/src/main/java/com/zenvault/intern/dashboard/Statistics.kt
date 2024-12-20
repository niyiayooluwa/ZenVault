package com.zenvault.intern.dashboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Statistics() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = Color(0xFFDDE4EE),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(
                start = 36.dp,
                end = 36.dp,
                top = 28.dp,
                bottom = 16.dp
            )
    ) {

        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
            .fillMaxWidth()
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {}
            ) {
                Text(
                    text = "Statistics",
                    fontSize = 18.sp,
                    fontWeight =  FontWeight.Medium,
                    color = Color(0xFF121212)
                )

                
                Icon(
                    Icons.Outlined.Info,
                    contentDescription = "Information",
                    modifier = Modifier.size(16.dp)
                )
            }



            Row (
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {}
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDDE4EE),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        start = 10.dp,
                        end = 8.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    )
            ) {
                Text(
                    text = "August 2024",
                    fontSize = 14.sp,
                    color = Color(0xFF475569),
                    fontWeight =  FontWeight.Medium
                )


                Icon(
                    Icons.Outlined.CalendarMonth,
                    contentDescription = "Calendar",
                    modifier = Modifier.size(18.dp),
                    tint = Color(0xFF475569)
                )
            }
        }

        Chart()

        LineUI(false)

        Summary()

    }
}


@Composable
fun Chart () {
    Box {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row {
                Column(
                    verticalArrangement = Arrangement.spacedBy(36.dp),
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .height(224.dp)
                        .width(39.dp)
                ) {
                    Text(
                        text = "₦60K",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF64748B)
                    )

                    Text(
                        text = "₦45K",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF64748B)
                    )

                    Text(
                        text = "₦30K",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF64748B)
                    )

                    Text(
                        text = "₦15K",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF64748B)
                    )

                    Text(
                        text = "0",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF64748B)
                    )
                }

                Spacer(modifier = Modifier.width(9.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(52.dp),
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .height(224.dp)
                        .width(271.dp)
                        .padding(vertical = 8.dp)
                ) {
                    LineUI()
                    LineUI()
                    LineUI()
                    LineUI()
                    LineUI(false)
                }
            }


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(319.dp)
                    .padding(start = 42.dp)
            ) {
                Days("Week 1")
                Days("Week 2")
                Days("Week 3")
                Days("Week 4")
            }
        }
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(26.dp),
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .width(264.dp)
                .height(215.dp)
                .padding(top = 70.dp)
                .align(Alignment.TopEnd)
        ){
            BarChartDrawer(
                incomeHeight = 121,
                expenseHeight = 56,
                income = true,
                expense = true,
            )

            BarChartDrawer(
                incomeHeight = 93,
                expenseHeight = 31,
                income = true,
                expense = true,
            )

            BarChartDrawer(
                incomeHeight = 140,
                expenseHeight = 80,
                income = true,
                expense = true,
            )

            BarChartDrawer(
                incomeHeight = 41,
                expenseHeight = 75,
                income = true,
                expense = true,
            )
        }
    }


}

@Composable
fun LineUI (isDashed : Boolean = true) {
    when (isDashed) {
        true -> {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            ) {
                val strokeWidth = 1.dp.toPx()
                val dashPathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)

                drawLine(
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    color = Color(0xFFDDE4EE),
                    strokeWidth = strokeWidth,
                    pathEffect = dashPathEffect
                )
            }
        }

        false -> { Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        ) {
            val strokeWidth = 1.dp.toPx()

            drawLine(
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                color = Color(0xFFDDE4EE),
                strokeWidth = strokeWidth,
            )
        } }
    }
}

@Composable
fun Days (
    text : String,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.width(60.dp)
    ){
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF64748B)
        )
    }
}

@Composable
fun BarChartDrawer (
    incomeHeight: Int,
    expenseHeight: Int,
    income : Boolean,
    expense : Boolean,
){
    Row (
        verticalAlignment = Alignment.Bottom
    ){
        Column(
            //Expense
            modifier = Modifier
                .height(incomeHeight.dp)
                .width(20.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(
                    when (income) {
                        true -> Color(0xFF10B982)
                        false -> Color.Transparent // Default color if no condition is met
                    }
                )
        ) {}


        Spacer(modifier = Modifier.width(6.dp))


        Column(
            //Expense
            modifier = Modifier
                .height(expenseHeight.dp)
                .width(20.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(
                    when (expense){
                        true -> Color(0xFF00442E)
                        false -> Color.Transparent // Default color if no condition is met
                    }
                )
        ) {}
    }
}


//@Preview(showBackground = true)
@Composable
fun Summary () {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(52.dp),
        modifier = Modifier
            .fillMaxWidth()
    ){
       Row (
           horizontalArrangement = Arrangement.spacedBy(8.dp),
           verticalAlignment = Alignment.Top,
           modifier = Modifier.clickable {}
       ){
           Column(
               verticalArrangement = Arrangement.Center,
               modifier = Modifier
                   .height(24.dp)
           ){
                Column(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFF10B982))
                ){}
           }

           Column(
               verticalArrangement = Arrangement.spacedBy(4.dp)
           ){
               Text(
                   text = "Income",
                   fontSize = 18.sp,
                   fontWeight = FontWeight.Medium,
                   color = Color(0xFF64748B)
               )

               Text(
                   text = "₦124,065",
                   fontSize = 24.sp,
                   fontWeight = FontWeight.SemiBold,
                   color = Color(0xFF171819)
               )
           }
       }


        Row (
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Top,
            modifier = Modifier.clickable {}
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(24.dp)
            ){
                Column(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFF00442E))
                ){}
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Text(
                    text = "Expense",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF64748B)
                )

                Text(
                    text = "₦63,550",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF171819)
                )
            }

        }
    }
}