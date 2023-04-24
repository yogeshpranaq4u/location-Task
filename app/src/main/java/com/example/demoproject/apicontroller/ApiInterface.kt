package com.example.demoproject.apicontroller

import com.example.demoproject.data.News
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("cnn.json")
    suspend fun getNews(): News
}