package com.baokhiem.mvvmarchcryptoapp.data.respository

import com.baokhiem.mvvmarchcryptoapp.data.remote.CoinPaprikaApi
import com.baokhiem.mvvmarchcryptoapp.data.remote.dto.CoinDetailDto
import com.baokhiem.mvvmarchcryptoapp.data.remote.dto.CoinDto
import com.baokhiem.mvvmarchcryptoapp.domain.respository.CoinRespository
import javax.inject.Inject

class CoinRespositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRespository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinByID(coinId)
    }
}