package com.example.demoproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.demoproject.data.BlogModel
import com.example.demoproject.databinding.ViewBlogFragmentBinding
import com.example.demoproject.listeners.ClickListeners

class ViewBlogFragment : BaseFragment(), ClickListeners {
    private var binding: ViewBlogFragmentBinding? = null

    //    private var reference: DatabaseReference? = null
    private var blogList: ArrayList<BlogModel>? = null
    private var adapter: BlogRecyclerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewBlogFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        reference = FirebaseDatabase.getInstance().getReference("Blogger")
        blogList = arrayListOf()

        /*reference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val user: BlogModel? = userSnapshot.getValue(BlogModel::class.java)
                        if (user != null) {
                            println("ViewBlogFragment.onDataChange ${user.namebloger}")
                            blogList?.add(user)
//                            println("ViewBlogFragment.onViewCreated ${blogList?.size}  // ${blogList?.get(0)}")
                        }
                    }

                    adapter = BlogRecyclerAdapter(blogList ?: return, this@ViewBlogFragment)
                    binding?.viewBlog?.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })*/
        newsViewModel.getBlogData()
        newsViewModel.myBlogsLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                println("ViewBlogFragment.onViewCreated ${it.namebloger}")
                blogList?.add(it)
            }
        })
        adapter = BlogRecyclerAdapter(blogList!!, this)
        binding?.viewBlog?.adapter = adapter
    }

    override fun onclick(position: Int) {

    }
}