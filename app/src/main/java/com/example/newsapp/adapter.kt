package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.newsapp.adapter.holder

class adapter(val contaxt: Context, val articalArrayList: List<Article>) :
    RecyclerView.Adapter<holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val itemView = LayoutInflater.from(contaxt).inflate(R.layout.layout_item,parent,false)
        return holder(itemView)
    }



    override fun onBindViewHolder(holder: holder, position: Int) {
        val currentItem = articalArrayList[position]

        holder.cardView.setOnClickListener {
            val intent = Intent(contaxt,webView::class.java)
            intent.putExtra("url",currentItem.url)
            contaxt.startActivity(intent)
        }
        holder.time.text=currentItem.publishedAt
        holder.author.text = currentItem.author
        holder.mainheading.text = currentItem.title
        holder.content.text = currentItem.description
        Glide.with(contaxt).load(currentItem.urlToImage).into(holder.imageview)
    }

    override fun getItemCount(): Int {
        return articalArrayList.size
    }

    class holder (itemView: View ) : RecyclerView.ViewHolder(itemView){
         var mainheading : TextView
         var content : TextView
         var author : TextView
         var time : TextView
         var cardView : CardView
         var imageview : ImageView

         init {
             mainheading = itemView.findViewById(R.id.mainheading)
             content = itemView.findViewById(R.id.content)
             author = itemView.findViewById(R.id.author)
             time = itemView.findViewById(R.id.time)
             cardView = itemView.findViewById(R.id.cardView)
             imageview = itemView.findViewById(R.id.imageview)
         }
    }
}