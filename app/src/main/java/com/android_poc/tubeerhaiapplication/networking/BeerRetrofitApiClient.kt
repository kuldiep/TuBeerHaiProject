package com.android_poc.tubeerhaiapplication.networking

import com.android_poc.tubeerhaiapplication.utility.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BeerRetrofitApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpLoggingInterceptorClient())
        .build()

    fun <T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }

    private fun httpLoggingInterceptorClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        return okHttpClientBuilder.build()
    }
}