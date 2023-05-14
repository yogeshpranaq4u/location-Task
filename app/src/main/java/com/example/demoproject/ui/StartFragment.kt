package com.example.demoproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.demoproject.R
import com.example.demoproject.Utits.fragmentList
import com.example.demoproject.Utits.fragmentTitleList
import com.example.demoproject.adapter.ViewpagerAdapter
import com.example.demoproject.databinding.StartFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class StartFragment : BaseFragment() {
    private var binding: StartFragmentBinding? = null
    private var adapter: ViewpagerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StartFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        clickListeners()
    }

    private fun init() {
        adapter = ViewpagerAdapter(
            fragmentList ?: return,
            fragmentTitleList,
            childFragmentManager,
            lifecycle
        )
        binding?.apply {
            newsViewpagerMain.adapter = adapter
            TabLayoutMediator(newsTab, newsViewpagerMain) { tab, position ->
                tab.text = adapter?.getPageTitle(position)
            }.attach()
        }
    }

    private fun clickListeners(){
        binding?.apply {
            createBlog.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_createBlogFragment)
            }
        }
    }
}