package com.zenvault.intern.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
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

val cards = listOf(

    Card(
        cardType = "MasterCard",
        cardNumber = "•• 9783",
        cardName = "Main Account",
        cardBalance = "465,860.16",
        imageIndex = 0
    ),

    Card(
        cardType = "Visa",
        cardNumber = "•• 2512",
        cardName = "Personal Savings",
        cardBalance = "230,460.11",
        imageIndex = 1
    ),

    Card(
        cardType = "Visa",
        cardNumber = "•• 8947",
        cardName = "Business Account",
        cardBalance = "986,470.23",
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
fun CardAlt(navController: NavController) {
    LazyRow(modifier = Modifier
        .clickable {
            navController.navigate("cards")
        }
        .padding(
            start = 16.dp,
            end = 16.dp,
            top = 8.dp,
            bottom = 4.dp
        )
    ) {
        items(cards.size) { index ->
            CardItems(index)
        }
    }
}

@Composable
fun CardItems(
    index: Int
)   {
    if (!cards[index].isLinkedNewCard) {
        val card = cards[index]
        var lastItemPaddingEnd = 16.dp

        if (index == cards.size - 1) {
            lastItemPaddingEnd = 0.dp
        }

        var image = painterResource(id = R.drawable.visa)
        if (card.cardType == "MasterCard") {
            image = painterResource(id = R.drawable.mastercard)
        }

        Box(
            modifier = Modifier
                .padding(
                    end = lastItemPaddingEnd
                )
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(200.dp)
                    .height(125.93.dp)
            ){
                Image(
                    painter = painterResource(id = imageResourced[card.imageIndex]),
                    contentDescription = "Card Image",
                    modifier = Modifier.fillMaxSize()
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)

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
                            fontSize = 11.sp
                        )
                    }


                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp)
                    ){
                        Text(
                            text = card.cardNumber,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 11.sp
                        )

                        Image(
                            painter = image,
                            contentDescription = "Card Type",
                            modifier = Modifier.size(24.dp)
                        )
                    }

                }
            }
        }
    }

    else {
        val card = cards[index]

        Box{
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(200.dp)
                    .height(125.93.dp)
            ){
                Image(
                    painter = painterResource(id = imageResourced[card.imageIndex]),
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
                        modifier = Modifier.size(24.dp)
                    )

                    Text(
                        text = "Connect New Card",
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp
                    )
                }
            }
        }
    }
}



// List of image resource IDs
val imageResourced = listOf(
    R.drawable.card_blue, // Index 0
    R.drawable.card_red,  // Index 1
    R.drawable.card_purple, // Index 2
    R.drawable.card_white //Index 3
)

