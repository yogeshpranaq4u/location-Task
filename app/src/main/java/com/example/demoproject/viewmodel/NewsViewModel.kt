package com.example.demoproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoproject.data.BlogModel
import com.example.demoproject.data.Medicine
import com.example.demoproject.data.News
import com.example.demoproject.repository.Repository
import com.google.firebase.database.*
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val myRepository = Repository()
    private var reference: DatabaseReference? = null

    private val myBlogs: MutableLiveData<BlogModel?> = MutableLiveData()
    val myBlogsLiveData: MutableLiveData<BlogModel?> = myBlogs

    private val myResponse: MutableLiveData<News> = MutableLiveData()
    val myNews: LiveData<News> = myResponse

    private val myBusinessResponse: MutableLiveData<News> = MutableLiveData()
    val myBusinessNews: LiveData<News> = myBusinessResponse

    private val myMedicalResponse: MutableLiveData<News> = MutableLiveData()
    val myMedicalNews: LiveData<News> = myMedicalResponse

    private val myMedicineResponse: MutableLiveData<Medicine> = MutableLiveData()
    val myMedicine: LiveData<Medicine> = myMedicineResponse

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

    fun getMedicineDetails() {
        viewModelScope.launch {
            val response = myRepository.getAllMedicalDetails()
            myMedicineResponse.value = response
        }
    }

    fun getBlogData(){
        reference = FirebaseDatabase.getInstance().getReference("Blogger")

        reference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val user: BlogModel? = userSnapshot.getValue(BlogModel::class.java)
                        viewModelScope.launch {
                            myBlogs.value = user
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

}