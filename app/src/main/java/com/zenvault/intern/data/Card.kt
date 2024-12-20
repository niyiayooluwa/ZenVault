package com.zenvault.intern.data

class Card(
    val cardType:String,
    val cardNumberLong: String,
    val cardNumber:String,
    val cardName:String,
    private var cardBalance: Double?,
    val cardExpDate: String,
    val cardCvv: Int?,
    val imageIndex: Int,
    // Flag to distinguish the "Link A New Card" section
    val isLinkedNewCard: Boolean = false
) {
    // Getter for cardBalance
    fun getCardBalance(): String {
        return if (cardBalance != null) {
            "₦%,.2f".format(cardBalance)
        } else {
            "Error Retrieving Balance"
        }
    }

    //Deposit function, to add money to the wallet or card first. Implementation not clear yet
    fun deposit(amount: Double) {
        if (amount < 100) throw
        IllegalArgumentException ("Deposit amount must be ₦100 and above")

        cardBalance = if (cardBalance == null) {
            amount
        } else {
            cardBalance?.plus(amount)
        }
    }

    fun withdraw(amount: Double) {
        if (amount <= 0) throw
                IllegalArgumentException ("Withdrawal amount must be greater than zero")

        if (cardBalance == null) throw IllegalStateException ("Invalid Operation")

        if(cardBalance!! >= amount) {
            cardBalance = cardBalance!! - amount
        } else {
            throw
                    IllegalArgumentException ("Insufficient Balance")
        }
    }

    fun getRawBalance(): Double? {
        return cardBalance
    }
}
