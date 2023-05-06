package com.example.demoproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.demoproject.R
import com.example.demoproject.Utits.SELECTED_POSITION
import com.example.demoproject.databinding.HomeFragmentBinding
import com.example.demoproject.listeners.ClickListeners
import com.example.demoproject.viewmodel.NewsViewModel

class HomeFragment : BaseFragment(),ClickListeners {
    private var binding: HomeFragmentBinding? = null
    private var adapter : RecyclerAdapter? = null
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
        observer()
    }
    private fun observer(){
        newsViewModel.getNews()
        newsViewModel.getMedicalNews()
        newsViewModel.myNews.observe(viewLifecycleOwner) { response ->
            adapter = RecyclerAdapter(response.articles, this)
            binding?.newsList?.adapter = adapter
        }

        binding?.newsList?.smoothScrollToPosition(SELECTED_POSITION)
    }

    override fun onclick(position: Int) {
        val bundle = bundleOf("pos" to position)
        findNavController().navigate(R.id.action_startFragment_to_newsViewFragment2, bundle)
        SELECTED_POSITION = position
    }
}
