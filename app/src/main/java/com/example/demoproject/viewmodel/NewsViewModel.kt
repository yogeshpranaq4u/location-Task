package com.example.demoproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.data.News
import com.example.demoproject.repository.Repository
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val myRepository = Repository()

    private val myResponse: MutableLiveData<News> = MutableLiveData()
    val myNews: LiveData<News> = myResponse

    private val myBusinessResponse: MutableLiveData<News> = MutableLiveData()
    val myBusinessNews: LiveData<News> = myBusinessResponse

    private val myMedicalResponse: MutableLiveData<News> = MutableLiveData()
    val myMedicalNews: LiveData<News> = myMedicalResponse

    fun getNews() {
        viewModelScope.launch {
            val response = myRepository.getAllNews()
            myResponse.value = response
        }
    }
    fun getBusinessNews() {
        viewModelScope.launch {
            val response = myRepository.getAllBusinessNews()
            myBusinessResponse.value = response
        }
    }
    fun getMedicalNews() {
        viewModelScope.launch {
            val response = myRepository.getAllMedicalNews()
            myMedicalResponse.value = response
        }
    }
}