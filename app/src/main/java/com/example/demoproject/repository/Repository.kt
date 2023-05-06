package com.example.demoproject.repository

import com.example.demoproject.apicontroller.ApiClient
import com.example.demoproject.data.Bussnies
import com.example.demoproject.data.News
import retrofit2.Call

class Repository {
    suspend fun getAllNews(): News{
        return ApiClient.api.getNews()
    }
    suspend fun getAllBusinessNews(): News{
        return ApiClient.apiBusiness.getBusinessNews()
    }
    suspend fun getAllMedicalNews(): News{
        return ApiClient.apiBusiness.getMedicalNews()
    }

}