package com.zenvault.intern.data

val card = mutableListOf(
    Card(
        cardType = "MasterCard",
        cardNumberLong = "9811 9533 2725 9783",
        cardNumber = "•• 9783",
        cardName = "Main Account",
        cardBalance = 465860.16,
        cardExpDate = "09/26",
        cardCvv = 249,
        imageIndex = 0
    ),

    Card(
        cardType = "Visa",
        cardNumberLong = "2873 6195 4958 2512",
        cardNumber = "•• 2512",
        cardName = "Personal Savings",
        cardBalance = 230460.11,
        cardExpDate = "05/25",
        cardCvv = 943,
        imageIndex = 1
    ),

    Card(
        cardType = "Visa",
        cardNumberLong = "2135 7913 2466 8947",
        cardNumber = "•• 8947",
        cardName = "Business Account",
        cardBalance = 986470.23,
        cardExpDate = "01/26",
        cardCvv = 772,
        imageIndex = 2
    ),

    Card(
        cardType = "",
        cardNumberLong = "",
        cardNumber = "",
        cardName = "",
        cardBalance = null,
        imageIndex = 3,
        cardExpDate = "",
        cardCvv = null,
        isLinkedNewCard = true
    ),
)

fun main() {
    card[0].getCardBalance()
}