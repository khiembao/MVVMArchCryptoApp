package com.baokhiem.mvvmarchcryptoapp.presentation.coin_detail

import com.baokhiem.mvvmarchcryptoapp.domain.model.Coin
import com.baokhiem.mvvmarchcryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
