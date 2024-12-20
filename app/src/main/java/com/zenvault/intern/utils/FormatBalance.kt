package com.zenvault.intern.utils

import java.text.NumberFormat
import java.util.*

fun formatBalance(amount: Double): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "NG"))
    return formatter.format(amount)
}
