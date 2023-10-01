package com.baokhiem.mvvmarchcryptoapp.domain.use_case.get_coin

import com.baokhiem.mvvmarchcryptoapp.common.Resource
import com.baokhiem.mvvmarchcryptoapp.data.remote.dto.toCoin
import com.baokhiem.mvvmarchcryptoapp.data.remote.dto.toCoinDetail
import com.baokhiem.mvvmarchcryptoapp.domain.model.Coin
import com.baokhiem.mvvmarchcryptoapp.domain.model.CoinDetail
import com.baokhiem.mvvmarchcryptoapp.domain.respository.CoinRespository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val respository: CoinRespository
){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow{
        try {
            emit(Resource.Loading())
            val coin = respository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        } catch (e: IOException){
            emit(Resource.Error("Check internet connection"))
        }
    }

}