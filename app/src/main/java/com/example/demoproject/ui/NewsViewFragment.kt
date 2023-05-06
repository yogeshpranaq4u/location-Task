package com.example.demoproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.demoproject.R
import com.example.demoproject.databinding.NewsViewFragmentBinding


class NewsViewFragment : BaseFragment() {
    private var binding: NewsViewFragmentBinding? = null
    private var position: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsViewFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        position = arguments?.getInt("pos", 0)
        observer()

    }

    private fun observer() {
        newsViewModel.myNews?.observe(viewLifecycleOwner, Observer {
            context?.let { it1 ->
                binding?.newsImage?.let { it2 ->
                    Glide.with(it1).load(position?.let { it2 -> it.articles.get(it2).urlToImage })
                        .into(
                            it2
                        )
                }
            }
            findNavController().currentDestination?.label = it?.articles?.get(position?:return@Observer)?.author
        })
    }
}