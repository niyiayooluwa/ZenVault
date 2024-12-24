package com.zenvault.intern.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
    showBackground = true,
)
@Composable
fun QuickTransferSection () {
    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp,
                vertical = 8.dp
            )
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 8.dp
                )
        ){
            Text(
                text = "Beneficiaries",
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = Color(0xFF7f7f7f)
            )

            Text(
                text = "EDIT",
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = Color(0xFF10b982),
                modifier = Modifier.clickable{}
            )
        }


        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            QuickTransferBox(
                image = R.drawable.add_outline, text = "Add"
            )
            QuickTransferBox(
                image = R.drawable.frame_7, text = "Will"
            )

            QuickTransferBox(
                image = R.drawable.frame_8, text = "Lebron"
            )

            QuickTransferBox(
                image = R.drawable.frame_9, "Anissa"
            )

            QuickTransferBox(
                image = R.drawable.frame_10, "Lee"
            )

            QuickTransferBox(
                image = R.drawable.frame_11,"Anna"
            )
        }
    }
}



@Composable
fun QuickTransferBox(
    image : Int,
    text : String
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {}
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Quick Transfer Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
                .size(35.dp)
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = text,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff475569),
        )
    }
}