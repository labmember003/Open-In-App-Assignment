package com.falcon.openinapp_assignment.di

import com.falcon.openinapp_assignment.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.inopenapp.com/api/v1/")
            .build()
    }

    @Singleton
    @Provides
    fun providesAPI(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}