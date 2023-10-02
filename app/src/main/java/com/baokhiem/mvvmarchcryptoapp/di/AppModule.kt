package com.baokhiem.mvvmarchcryptoapp.di

import com.baokhiem.mvvmarchcryptoapp.common.Constants
import com.baokhiem.mvvmarchcryptoapp.data.remote.CoinPaprikaApi
import com.baokhiem.mvvmarchcryptoapp.data.respository.CoinRespositoryImpl
import com.baokhiem.mvvmarchcryptoapp.domain.respository.CoinRespository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRespository(api: CoinPaprikaApi): CoinRespository{
        return CoinRespositoryImpl(api)
    }
}