package com.example.demoproject.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoproject.R
import com.example.demoproject.data.Article
import com.example.demoproject.data.BlogModel
import com.example.demoproject.listeners.ClickListeners
import com.google.android.material.textview.MaterialTextView

class BlogRecyclerAdapter(private val list: List<BlogModel>, private val clickListeners: ClickListeners) :
    RecyclerView.Adapter<BlogRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_iems, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(list, context = holder.itemView.context,clickListeners)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: MaterialTextView? = null
        var author: MaterialTextView? = null
        var content: MaterialTextView? = null
        var image: ImageView? = null
        var newsLayout: ConstraintLayout? = null

        init {
            title = view.findViewById(R.id.title)
            author = view.findViewById(R.id.author)
            content = view.findViewById(R.id.content)
            image = view.findViewById(R.id.newsImage)
            newsLayout = view.findViewById(R.id.newsLayout)
        }

        fun bindView(list: List<BlogModel>, context: Context, clickListeners: ClickListeners) {
            title?.text = list[adapterPosition].title
            image?.let {
                Glide
                    .with(context)
                    .load(list[adapterPosition].imageurl)
                    .into(it)
            }
            author?.text = list[adapterPosition].namebloger
            content?.text = list[adapterPosition].content
            newsLayout?.setOnClickListener {
                clickListeners.onclick(adapterPosition)
            }
        }
    }

}