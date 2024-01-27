package com.falcon.openinapp_assignment.di

import com.falcon.openinapp_assignment.api.ApiService
import com.falcon.openinapp_assignment.api.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl("https://api.inopenapp.com/api/v1/")
    }
    @Singleton
    @Provides
    fun provideHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor).build()
    }
    @Singleton
    @Provides
    fun providesAPI(retrofitBuilder: Retrofit.Builder, okHttpClient: OkHttpClient): ApiService {
        return retrofitBuilder
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

}