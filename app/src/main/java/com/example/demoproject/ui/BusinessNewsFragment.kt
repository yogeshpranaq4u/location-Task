package com.example.demoproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.demoproject.databinding.BusinessNewsFragmentBinding
import com.example.demoproject.listeners.ClickListeners

class BusinessNewsFragment():BaseFragment(), ClickListeners{
    private var binding: BusinessNewsFragmentBinding? = null
    private var adapter: RecyclerAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BusinessNewsFragmentBinding.inflate(inflater, container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
    }
    private fun observer(){
        newsViewModel.getBusinessNews()
        newsViewModel.myBusinessNews.observe(viewLifecycleOwner, Observer {
            adapter = RecyclerAdapter(it.articles,this)
            binding?.businessRecycler?.adapter= adapter
        })
    }

    override fun onclick(position: Int) {

    }

}