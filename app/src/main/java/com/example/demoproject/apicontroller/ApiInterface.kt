package com.example.demoproject.apicontroller

import com.example.demoproject.Utits.API_KEY
import com.example.demoproject.data.Bussnies
import com.example.demoproject.data.Medicine
import com.example.demoproject.data.News
import com.google.android.gms.common.api.internal.ApiKey
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("cnn.json")
    suspend fun getNews(): News
    @GET("top-headlines?country=in&category=business&$API_KEY")
    suspend fun getBusinessNews():News
    @GET("top-headlines?country=in&category=health&$API_KEY")
    suspend fun getMedicalNews() : News

    @GET("top-headlines?country=in&category=technology&$API_KEY")
    suspend fun getTechnologyNews() : News

    @GET("top-headlines?country=in&category=sports&$API_KEY")
    suspend fun getSportsNews() : News

    @GET("top-headlines?country=in&category=entertainment&$API_KEY")
    suspend fun getEntertainmentNews() : News

    @GET("druginfo?drug=advil")
    suspend fun getMedicalDetails() : Medicine
}