package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout :TabLayout
    lateinit var viewpage : ViewPager2
     var api = "8fd6995fef044920b5c4b41d18f78653"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout);
        viewpage = findViewById(R.id.viewpage)

        val adapter = MyFagmentAdapter(this)
        adapter.addFragment(HomeFragment(),"HOME")
        adapter.addFragment(SportsFragment(),"SPORTS")
        adapter.addFragment(HealthFragment(),"HEALTH")
        adapter.addFragment(ScienceFragment(),"SCIENCE")
        adapter.addFragment(TechnologyFragment(),"TECHNOLOGY")

        viewpage.adapter = adapter

        TabLayoutMediator(
            tabLayout, viewpage
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }
}