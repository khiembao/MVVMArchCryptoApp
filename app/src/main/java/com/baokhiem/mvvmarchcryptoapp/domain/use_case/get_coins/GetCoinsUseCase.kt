package com.baokhiem.mvvmarchcryptoapp.domain.use_case.get_coins

import com.baokhiem.mvvmarchcryptoapp.common.Resource
import com.baokhiem.mvvmarchcryptoapp.data.remote.dto.toCoin
import com.baokhiem.mvvmarchcryptoapp.domain.model.Coin
import com.baokhiem.mvvmarchcryptoapp.domain.respository.CoinRespository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val respository: CoinRespository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = respository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Error"))
        } catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Check internet connection"))
        }
    }

}