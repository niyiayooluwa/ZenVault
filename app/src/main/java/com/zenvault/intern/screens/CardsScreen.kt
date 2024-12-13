package com.zenvault.intern.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
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
import com.zenvault.intern.data.Card

val mycard = listOf(

    Card(
        cardType = "MasterCard",
        cardNumber = "•• 9783",
        cardName = "Main Account",
        cardBalance = "₦465,860.16",
        imageIndex = 0
    ),

    Card(
        cardType = "Visa",
        cardNumber = "•• 2512",
        cardName = "Personal Savings",
        cardBalance = "₦230,460.11",
        imageIndex = 1
    ),

    Card(
        cardType = "Visa",
        cardNumber = "•• 8947",
        cardName = "Business Account",
        cardBalance = "₦986,470.23",
        imageIndex = 2
    ),

    Card(
        cardType = "",
        cardNumber = "",
        cardName = "",
        cardBalance = null,
        imageIndex = 3,
        isLinkedNewCard = true
    ),
)

@Composable
fun CardsScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
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
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Cards",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
            ) {
                items(mycard.size) { index ->
                    CardItem(index)
                }
            }
        }
    }
}



@Composable
fun CardItem(
    index: Int
) {
    if (!mycard[index].isLinkedNewCard) {
        val card = mycard[index]

        var image = painterResource(id = R.drawable.visa)
        if (card.cardType == "MasterCard") {
            image = painterResource(id = R.drawable.mastercard)
        }

        Box(
            modifier = Modifier
                .clickable {}
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(380.dp)
                    .height(239.36.dp)
            ){
                Image(
                    painter = painterResource(id = imageResource[card.imageIndex]),
                    contentDescription = "Card Image",
                    modifier = Modifier.fillMaxSize()
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 12.dp)

                ) {
                    Row (
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp)
                    ){
                        Text(
                            text = card.cardName,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    }


                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        card.cardBalance?.let {
                            Text (
                                text = it,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 32.sp
                            )
                        }
                    }


                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            text = card.cardNumber,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 20.sp
                        )

                        Image(
                            painter = image,
                            contentDescription = "Card Type",
                            modifier = Modifier.size(40.dp)
                        )
                    }

                }
            }
        }
    }

    else {
        val card = mycard[index]

        Box{
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(380.dp)
                    .height(239.26.dp)
                    .clickable {}
            ){
                Image(
                    painter = painterResource(id = imageResource[card.imageIndex]),
                    contentDescription = "Card Image",
                    modifier = Modifier.fillMaxSize()
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        )
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(R.drawable.add_outline),
                        contentDescription = "Add Icon",
                        modifier = Modifier.size(48.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Connect New Card",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}




val imageResource = listOf(
    R.drawable.card_blue, // Index 0
    R.drawable.card_red,  // Index 1
    R.drawable.card_purple, // Index 2
    R.drawable.card_white //Index 3
)