package com.zenvault.intern.utils

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavController
import com.zenvault.intern.R
import com.zenvault.intern.data.Card
import com.zenvault.intern.data.card


enum class CardSize {
    Small, Big
}


val imageID = listOf(
    R.drawable.card_blue, // Index 0
    R.drawable.card_red,  // Index 1
    R.drawable.card_purple, // Index 2
    R.drawable.card_white //Index 3
)

@Composable
fun CardItem(
    card: Card,
    cardSize: CardSize,
    onClick: () -> Unit = {}

) {
    val imageRes = when (card.cardType) {
        "MasterCard" -> R.drawable.mastercard
        "Visa" -> R.drawable.visa
        else -> R.drawable.ic_round_credit_card // Default fallback
    }

    if (!card.isLinkedNewCard) {
        Box(
            modifier = Modifier
                .clickable {onClick()}
                .clip(RoundedCornerShape(12.dp))
                .width(
                    when (cardSize)  {
                        CardSize.Small -> 200.dp
                        CardSize.Big -> 380.dp
                    })
                .height(
                    when (cardSize)  {
                        CardSize.Small -> 125.93.dp
                        CardSize.Big -> 239.36.dp
                    }
                )
        ){
            Image(
                painter = painterResource(id = imageID[card.imageIndex]),
                contentDescription = "Card Image",
                modifier = Modifier.fillMaxSize()
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = when (cardSize) {
                            CardSize.Small -> 16.dp
                            CardSize.Big -> 24.dp
                    },
                        end = when (cardSize) {
                            CardSize.Small -> 16.dp
                            CardSize.Big -> 24.dp
                        },

                        top = when (cardSize) {
                            CardSize.Small -> 0.dp
                            CardSize.Big -> 16.dp
                        },

                        bottom = when (cardSize) {
                            CardSize.Small -> 2.dp
                            CardSize.Big -> 8.dp
                        }
                    )

            ) {
                //Card Name
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
                        fontSize = when (cardSize) {
                            CardSize.Small -> 11.sp
                            CardSize.Big -> 20.sp
                        }
                    )
                }

                if (cardSize == CardSize.Big) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        card.getRawBalance()?.let {
                            Text (
                                text = formatBalance(it),
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 32.sp
                            )
                        }
                    }
                }

                //Card Number truncated and Card provider logo
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(
                            when (cardSize) {
                                CardSize.Small -> 24.dp
                                CardSize.Big -> 40.dp
                            }
                        )
                ){
                    Text(
                        text = card.cardNumber,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = when (cardSize) {
                            CardSize.Small -> 11.sp
                            CardSize.Big -> 20.sp
                        }
                    )

                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = "Card Type",
                        modifier = Modifier.size(
                            when (cardSize) {
                                CardSize.Small -> 24.dp
                                CardSize.Big -> 40.dp
                            }
                        )
                    )
                }

            }
        }
    }
    else {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .width(
                    when (cardSize)  {
                        CardSize.Small -> 200.dp
                        CardSize.Big -> 380.dp
                    })
                .height(
                    when (cardSize)  {
                        CardSize.Small -> 125.93.dp
                        CardSize.Big -> 239.36.dp
                    }
                )
        ){
            Image(
                painter = painterResource(id = imageID[card.imageIndex]),
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
                    modifier = Modifier.size(
                        when (cardSize) {
                            CardSize.Small -> 24.dp
                            CardSize.Big -> 48.dp
                        }
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Connect New Card",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF121212),
                    fontSize = when (cardSize) {
                        CardSize.Small -> 11.sp
                        CardSize.Big -> 24.sp
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun CardList() {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardItem (
            card = card[3],
            cardSize = CardSize.Big
        )

        CardItem (
            card = card[3],
            cardSize = CardSize.Small
        )
    }
}