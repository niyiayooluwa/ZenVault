package com.zenvault.intern.utils

import com.zenvault.intern.data.Card
import com.zenvault.intern.data.card

object CardOperations {
    val cards: MutableList<Card> = card

    // Deposit method
    fun deposit(cardNumber: String, amount: Double) {
        val card = cards.find { it.cardNumber == cardNumber }
        card?.deposit(amount)
    }

    // Transfer method
    fun transfer(fromCardNumber: String, toCardNumber: String, amount: Double) {
        val fromCard = cards.find { it.cardNumber == fromCardNumber }
        val toCard = cards.find { it.cardNumber == toCardNumber }

        if (fromCard != null && toCard != null) {
            fromCard.withdraw(amount)
            toCard.deposit(amount)
        }
    }

    // Get total balance across all cards
    fun getTotalBalance(): Double {
        return cards.sumOf { it.getRawBalance() ?: 0.0 }
    }
}
