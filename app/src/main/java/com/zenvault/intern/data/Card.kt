package com.zenvault.intern.data

data class Card(
    val cardType:String,
    val cardNumber:String,
    val cardName:String,
    val cardBalance: String?,
    val imageIndex: Int,
    // Flag to distinguish the "Link A New Card" section
    val isLinkedNewCard: Boolean = false
)
