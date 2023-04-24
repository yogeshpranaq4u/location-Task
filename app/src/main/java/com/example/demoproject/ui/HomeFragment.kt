package com.example.demoproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoproject.databinding.HomeFragmentBinding
import com.example.demoproject.repository.Repository
import com.example.demoproject.viewmodel.NewsViewModel
import com.example.demoproject.viewmodel.ViewModelFactory

class HomeFragment : Fragment() {
    private var binding: HomeFragmentBinding? = null
    private var newsViewModel: NewsViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myRepository = Repository()
        val viewModelFactory = ViewModelFactory(myRepository)
        newsViewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)
        newsViewModel?.getNews()
        newsViewModel?.myNews?.observe(viewLifecycleOwner) { response ->
            println("HomeFragment.onViewCreated ${response.articles.get(0).author}")
            println("HomeFragment.onViewCreated 11 ${response.totalResults}")
        }
    }
}
