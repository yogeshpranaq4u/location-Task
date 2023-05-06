package com.example.demoproject.apicontroller

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient  {
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

    val api: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

    val apiBusiness: ApiInterface by lazy {
        retrofit2.create(ApiInterface::class.java)
    }

}