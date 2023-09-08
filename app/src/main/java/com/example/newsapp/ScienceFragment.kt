package com.example.newsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ScienceFragment : Fragment() {
    var apiKey = "8fd6995fef044920b5c4b41d18f78653"
    var articalArrayList : ArrayList<Article> = ArrayList()
    lateinit var adapter: adapter
    var country = "in"
    lateinit var recyclerView: RecyclerView
    var category = "science"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_science, container, false)

        recyclerView = view.findViewById(R.id.recViewSc)
//        articalArrayList = ArrayList()
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = adapter(requireContext(),articalArrayList)
        recyclerView.adapter = adapter

        findNews()

        return  view
    }

    private fun findNews() {
        ApiUtilities.ApiControlor()?.getCategoryNews(country,category,100,apiKey)?.enqueue(object : Callback<MyData?> {

            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                if (response.isSuccessful){
                    articalArrayList.addAll(response.body()!!.articles)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}