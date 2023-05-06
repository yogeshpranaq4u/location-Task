package com.example.demoproject.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.demoproject.viewmodel.NewsViewModel

open class BaseFragment:Fragment() {
    val newsViewModel: NewsViewModel by activityViewModels()

}