package com.example.demoproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.demoproject.R
import com.example.demoproject.Utits.SELECTED_POSITION
import com.example.demoproject.databinding.HomeFragmentBinding
import com.example.demoproject.listeners.ClickListeners

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
        newsViewModel.getMedicineDetails()
        newsViewModel.myNews.observe(viewLifecycleOwner) { response ->
            println("HomeFragment.observer ${response.articles[0].urlToImage}")
            adapter = RecyclerAdapter(response.articles, this)
            binding?.newsList?.adapter = adapter
        }
        newsViewModel.myMedicine.observe(viewLifecycleOwner) { response ->
            println("HomeFragment.observer ${response.size} // ${response[0].brand_name}")
        }


        binding?.newsList?.smoothScrollToPosition(SELECTED_POSITION)
    }

    override fun onclick(position: Int) {
        val bundle = bundleOf("pos" to position)
        findNavController().navigate(R.id.action_startFragment_to_newsViewFragment2, bundle)
        SELECTED_POSITION = position
    }
}
