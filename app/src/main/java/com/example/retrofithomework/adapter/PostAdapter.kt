package com.example.retrofithomework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofithomework.R
import com.example.retrofithomework.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(var postList: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    inner class PostViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
        fun bind(post: Post){
            itemView.txtTitle.text= post.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {


        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false))

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

}