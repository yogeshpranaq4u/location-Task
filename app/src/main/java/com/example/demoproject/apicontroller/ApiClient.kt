package com.example.demoproject.apicontroller

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://saurav.tech/NewsAPI/everything/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val retrofit2 by lazy {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val retrofitMedicine by lazy {
        Retrofit.Builder()
            .baseUrl("https://drug-info-and-price-history.p.rapidapi.com/1/")
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

    val apiBusiness: ApiInterface by lazy {
        retrofit2.create(ApiInterface::class.java)
    }
    val apiMedicine: ApiInterface by lazy {
        retrofitMedicine.create(ApiInterface::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        addHeader(okHttpClient)
        return okHttpClient.build()
    }

    private fun addHeader(okHttpClient: OkHttpClient.Builder) {
        okHttpClient.interceptors().add(Interceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("X-RapidAPI-Key", "e66270a026msh9f7c2882815715ap1ac8cbjsnea380cdd2e36")
                .addHeader("X-RapidAPI-Host", "drug-info-and-price-history.p.rapidapi.com")
                .build()
            chain.proceed(request)
        })
    }


}