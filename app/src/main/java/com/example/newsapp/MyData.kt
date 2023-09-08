package com.example.newsapp

data class MyData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)