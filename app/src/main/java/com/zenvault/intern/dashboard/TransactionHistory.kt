package com.zenvault.intern.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zenvault.intern.R

@Preview (showBackground = true)
@Composable
fun TransactionHistory(

) {
    Column(
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
                bottom = 16.dp,
                top = 28.dp
            )
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Recent Transactions",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF121212)
            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.clickable {}
            ){
                Text(
                    text = "SEE MORE",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF10B982)
                )

                Icon(
                    Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                    contentDescription = "Arrow right",
                    tint = Color(0xFF10b982)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column (
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TransactionItems(
                image = R.drawable.vector,
                amount = "+ ₦18,000.00",
                time = "11:36 AM",
                title = "Toni Martins",
            )

            Spacer(modifier = Modifier.height(16.dp))

            TransactionItems(
                image = R.drawable.ic_round_credit_card,
                amount2 = "- ₦8,400.00",
                time = "12:28 PM",
                title = "NIP-Card Transfer",
            )

            Spacer(modifier = Modifier.height(16.dp))

            TransactionItems(
                image = R.drawable.mdi_spotify,
                amount3 = "- ₦1300.00",
                time = "9:16 AM",
                title = "Spotify Subscription",
                status = "Failed"
            )
        }
    }

}

@Composable
private fun TransactionItems(
    image: Int,
    amount: String? = null,
    amount2: String? = null,
    amount3: String? = null,
    time: String,
    title: String,
    status: String? = null
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
            )
            .clickable {}
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF121212)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row {
                    Text(
                        text = time,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFF121212)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    if (status != null) {
                        Text(
                            text = status,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.Red
                        )
                    }
                }
            }
        }

        when {
            amount != null -> {
                Text(
                    text = amount,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF10B982)
                )
            }
            amount2 != null -> {
                Text(
                    text = amount2,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF121212)
                )
            }
            amount3 != null -> {
                Text(
                    text = amount3,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF121212),
                    textDecoration = TextDecoration.LineThrough
                )
            }
        }
    }
}


