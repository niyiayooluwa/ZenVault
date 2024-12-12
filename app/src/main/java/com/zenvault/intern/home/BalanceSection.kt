package com.zenvault.intern.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.rounded.KeyboardArrowRight
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

@Preview(
    showSystemUi = false,
    showBackground = true,)
@Composable
fun BalanceSection () {
    Column(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp)
    ) {
        Text(
            text = "Total Balance",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF7f7f7f),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "₦1,682,780.50",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF121212)
        )

        Spacer(modifier = Modifier.height(8.dp))

        //Cashback Section
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable{}
        ) {

            //Coin Icon
            Image(
                painter = painterResource(R.drawable.ph_coins),
                contentDescription = "Coins",
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFD9D9D9))
                    .padding(4.dp)

            ){
                //Coin Icon
                Image(
                    painter = painterResource(R.drawable.ph_coins),
                    contentDescription = "Ciins",
                    modifier = Modifier.size(12.dp)
                )

                Spacer(
                    modifier = Modifier.width(4.dp)
                )

                //Total Earned Cashback
                Text(
                    text = "₦240.16",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF121212),
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            //With the fulllogic, this part would be like a button to view their cashback details
            Text(
                text = "Earned Cashback",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF121212),
            )

            //Icon >
            Icon(
                Icons.Rounded.KeyboardArrowRight,
                contentDescription = "Arrow right",
                modifier = Modifier.size(24.dp)
            )

        }

        
    }
}