package com.zenvault.intern.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zenvault.intern.R

@Preview(
    showSystemUi = false,
    showBackground = true,

)
@Composable
fun GreetingSection() {
    Row (
        modifier= Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp,
                top = 16.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        ) {
        //Avatar and Name Section of the design
        Box(
            modifier = Modifier.clickable{}
        ) {
            //Name section
            Row (
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFD9D9D9))
                    .height(36.dp)
                    .width(128.dp)
                    .padding(start = 8.dp)
            ){
                Text(
                    text = "Cillian. M",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

                /*Arrow right Icon. CLicking on this should take you to the user profile
                  which is also accessible from the more section of the navigation bar
                 */

                Icon(
                    Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                    contentDescription = "Arrow right",
                    tint = Color(0xFF10b982)
                )
            }


            //Avatar section with a border and rounded corners
           Image(
               painter = painterResource(id = R.drawable.cillian_m),
               contentDescription = "User Profile Picture",
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .align(Alignment.CenterStart)
                   .size(44.dp)
                   .clip(RoundedCornerShape(12.dp))
                   .border(
                       width = 2.dp,
                       color = Color(0xFF10b982),
                       shape = RoundedCornerShape(12.dp)
                   )
           )

        }


        //Container for Notification Button
        Box(
            modifier = Modifier
                .padding(8.dp)
                .clickable {}
        ) {
            // Notification Count
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .background( // Background with CircleShape
                        Color(0xFF10b982),
                        RoundedCornerShape(26.dp)
                    ) // Background with CircleShape
                    .height(30.dp) // Ensure it's a circle
                    .width(60.dp)
                    .padding(end = 3.dp)
            ) {
                Text(
                    text = "9+",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterEnd) // Center the text
                )
            }

            // Notification Icon
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White) // Add background color for the circle
                    .border(1.dp, Color(0xFF121212), CircleShape)
                    .align(Alignment.CenterStart) // Align icon to start
            ) {
                Icon(
                    painter = painterResource(R.drawable.hugeicons_notification),
                    contentDescription = "Notifications",
                    tint = Color(0xFF121212),
                    modifier = Modifier
                        .size(32.dp) // Size of the icon
                        .align(Alignment.Center) // Center the icon inside the circle
                )
            }
        }
    }
}

