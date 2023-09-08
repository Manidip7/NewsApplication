package com.example.newsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiUtilities {
    private val BASE_URL = "https://newsapi.org/v2/"
    private var retrofit: Retrofit? = null

    fun ApiControlor(): ApiInterface? {
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit?.create(ApiInterface::class.java)

    }
}