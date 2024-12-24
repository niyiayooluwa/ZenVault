package com.zenvault.intern.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TransferViewModel : ViewModel() {
    var accountNumber = mutableStateOf("")
    var selectedBank = mutableStateOf("")
}