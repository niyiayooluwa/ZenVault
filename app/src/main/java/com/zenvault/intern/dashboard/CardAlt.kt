package com.zenvault.intern.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zenvault.intern.data.card
import com.zenvault.intern.utils.CardItem
import com.zenvault.intern.utils.CardSize

@Composable
fun CardAlt(navController: NavController) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("cards")}
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 4.dp
            )

    ) {
        items(card) { cardItem ->
            CardItem(
                card = cardItem, // Pass each card from your list
                cardSize = CardSize.Small,
            )
        }
    }
}


