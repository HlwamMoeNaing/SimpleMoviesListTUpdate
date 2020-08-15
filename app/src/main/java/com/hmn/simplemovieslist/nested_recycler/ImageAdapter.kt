package com.hmn.simplemovieslist.nested_recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.room.entity.TopEntity
import com.squareup.picasso.Picasso

class ImageAdapter(val context: Context) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    val list = arrayListOf<TopEntity>()

    fun addData(newList: List<TopEntity>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mediaItem = itemView.findViewById<AppCompatImageView>(R.id.media_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.horizontal_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        var url = list[position].url
        if (url.contains("hqdefault.jpg"))
            url = url.replace("hqdefault.jpg", "mqdefault.jpg")
        Picasso.get().load(url).into(holder.mediaItem)
    }


}