package com.baokhiem.mvvmarchcryptoapp.presentation.coin_list

import com.baokhiem.mvvmarchcryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
