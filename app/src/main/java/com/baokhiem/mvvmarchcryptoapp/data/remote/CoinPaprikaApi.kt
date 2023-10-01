package com.baokhiem.mvvmarchcryptoapp.data.remote

import com.baokhiem.mvvmarchcryptoapp.data.remote.dto.CoinDetailDto
import com.baokhiem.mvvmarchcryptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/voins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinByID(@Path("coinId") coinId:String): CoinDetailDto
}