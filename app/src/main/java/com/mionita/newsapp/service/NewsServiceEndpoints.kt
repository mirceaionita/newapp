package com.mionita.newsapp.service

import com.mionita.newsapp.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServiceEndpoints {

    @GET("news/v3/content/all/all.json")
    fun getNews(@Query("api-key") key: String): Call<News>

    @GET("topstories/v2/science.json")
    fun getTopStoriesScience(@Query("api-key") key: String): Call<News>

    @GET("topstories/v2/world.json")
    fun getTopStoriesWorld(@Query("api-key") key: String): Call<News>
}