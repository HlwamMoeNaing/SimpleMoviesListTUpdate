package com.hmn.simplemovieslist.adapter.favouriteadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.room.entity.PopularFavouriteEntity
import com.hmn.simplemovieslist.R
import com.squareup.picasso.Picasso

class PopularFavouriteAdapter(val context: Context, val list: List<PopularFavouriteEntity>) :
    RecyclerView.Adapter<PopularFavouriteAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.iv_favourite)
        val desc = view.findViewById<TextView>(R.id.tv_favourite_desc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.favourite_item, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.desc.text = list[position].desc
        Picasso.get().load(list[position].url).resize(120,120).into(holder.img)
    }
}