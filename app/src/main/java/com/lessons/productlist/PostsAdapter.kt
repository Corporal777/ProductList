package com.lessons.productlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    private var posts: List<Posts> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    fun update(list: List<Posts>) {
        this.posts = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(posts: Posts) = with(itemView) {


            tv_post.text = posts.body
            tv_number.text = posts.id
        }
    }
}