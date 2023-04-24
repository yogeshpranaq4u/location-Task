package com.example.demoproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.data.News
import com.example.demoproject.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call

class NewsViewModel(private val repository: Repository):ViewModel() {

    private val myResponse : MutableLiveData<News> = MutableLiveData()
    val myNews:LiveData<News> = myResponse

    fun getNews(){
        viewModelScope.launch {
            val response = repository.getAllNews()
            myResponse.value = response
        }
    }
}