package com.example.retrofithomework

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofithomework.adapter.PostAdapter
import com.example.retrofithomework.api.PostApiInterface
import com.example.retrofithomework.model.Post
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPost()
    }

    fun loadpostList(postList: List<Post>) {
        recyclerPost.apply {
            layoutManager = LinearLayoutManager(context)
            val postAdapter = PostAdapter(postList)
            adapter = postAdapter
        }

    }

    fun getPost() {
        var BASE_URL = "https://jsonplaceholder.typicode.com/"
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(PostApiInterface::class.java)

        var apiCall = retrofitService.getPost()

        apiCall.enqueue(object :
            Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("Failure>>>>>>>>>>", t.toString())

            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                var postList = response.body()
                Log.d("Response>>>>>>>>>>", postList.toString())

                if (postList != null) {
                    loadpostList(postList)
                }
            }

        })

    }
}

