package com.example.demoproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.demoproject.data.BlogModel
import com.example.demoproject.databinding.BlogCreateFragmentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateBlogFragment : BaseFragment() {
    private var binding: BlogCreateFragmentBinding? = null
    private var db: FirebaseDatabase? = null
    private var reference: DatabaseReference? = null
    private var blogName: String? = null
    private var blogTitle: String? = null
    private var blogContent: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BlogCreateFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            submit.setOnClickListener {

                blogName = bloggerName.text.toString()
                blogTitle = title.text.toString()
                blogContent = content.text.toString()

                var blog =
                    BlogModel(
                        blogName ?: return@setOnClickListener,
                        "https://cdn.cnn.com/cnnnext/dam/assets/220504173124-11-champions-league-semifinal-real-madrid-manchester-city-super-tease.jpg",
                        blogTitle ?: return@setOnClickListener,
                        blogContent ?: return@setOnClickListener
                    )
                db = FirebaseDatabase.getInstance()
                reference = db?.getReference("Blogger")
                reference?.child(blogName?:return@setOnClickListener)?.setValue(blog)
                    ?.addOnCompleteListener {
                        findNavController().navigateUp()
                    }
            }
        }
    }
}
