package com.example.retrofithomework.api

import com.example.retrofithomework.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostApiInterface {
    @GET("posts")
    fun getPost(): Call<List<Post>>
}