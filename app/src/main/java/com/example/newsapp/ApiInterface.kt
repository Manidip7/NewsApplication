package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

//    @GET("products")
//    fun  getProductData() : Call<MyData>

    @GET("top-headlines")
    fun  getNews(
        @Query("country") country : String,
        @Query("pageSize") pagesize : Int,
        @Query("apiKey") apiKey : String

    ) : Call<MyData>

    @GET("top-headlines")
    fun  getCategoryNews(
        @Query("country") country : String,
        @Query("category") category : String,
        @Query("pageSize") pagesize : Int,
        @Query("apiKey") apikey : String

    ) : Call<MyData>
}