package com.baokhiem.mvvmarchcryptoapp.domain.respository

import com.baokhiem.mvvmarchcryptoapp.data.remote.dto.CoinDetailDto
import com.baokhiem.mvvmarchcryptoapp.data.remote.dto.CoinDto

interface CoinRespository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}