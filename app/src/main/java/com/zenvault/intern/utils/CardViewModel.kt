package com.zenvault.intern.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zenvault.intern.data.Card

class CardViewModel : ViewModel() {
    private val _selectedCard = MutableLiveData<Card?>()
    val selectedCard: LiveData<Card?> = _selectedCard

    fun selectCard(card: Card) {
        _selectedCard.value = card
    }
}