package com.zenvault.intern.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zenvault.intern.data.Card

class TransferViewModel : ViewModel() {
    private val _accountNumber = MutableLiveData<String>("")
    val accountNumber: LiveData<String> = _accountNumber

    private val _selectedBank = MutableLiveData<String>("")
    val selectedBank: LiveData<String> = _selectedBank

    private val _amount = MutableLiveData<String>("")
    val amount: LiveData<String> = _amount

    private val _name = MutableLiveData<String>("")
    val name: LiveData<String> get() = _name


    init{_name.value = generateName()}

    fun setAmount(amount: String) {
        _amount.value = amount
    }

    fun setAccountNumber(number: String) {
        _accountNumber.value = number
    }

    fun setSelectedBank(bank: String) {
        _selectedBank.value = bank
    }

    //Function to generate a name out of a list of names
    private fun generateName(): String {
        val baseWords = listOf(
            "Richard Wayne Johnson", "Ethan Olivia Davis", "Liam James Anderson", "Olivia Miller Wilson", "Sophia Noah Garcia", "Isabella Carter Martinez",
            "Sophia Bennett Rodriguez", "Liam Mitchell Perez", "Ava Harper Brown", "Noah Adams Clark", "Olivia Brooks Lewis",
            "Mason Walker Hall", "Isabella Foster Young", "Lucas Hayes Allen", "Charlotte Reed King", "Henry James Wright",
            "Amelia Cooper Hill", "Alexander Gray Scott", "Mia Taylor Green", "Benjamin Lewis Adams", "Emma Robinson Baker",
            "Daniel Scott Kelly", "Matthew Turner Collins", "Ella Jenkins Mitchell"
        )

        return baseWords.random()
    }
}



