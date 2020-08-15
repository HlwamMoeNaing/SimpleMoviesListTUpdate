package com.hmn.simplemovieslist.nested_recycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.utils.Util
import com.squareup.picasso.Picasso

class LatestSuggAdapter(val context: Context):RecyclerView.Adapter<LatestSuggAdapter.ViewHolder>() {
private val list =Util.newList

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val profilePhoto = view.findViewById<ImageView>(R.id.img_avatar)
        val feedPhoto = view.findViewById<ImageView>(R.id.image_feed)
        val userName = view.findViewById<TextView>(R.id.tv_username)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LatestSuggAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.vertical_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LatestSuggAdapter.ViewHolder, position: Int) {

      Picasso.get().load(list[position].image).into(holder.feedPhoto)
        holder.userName.text = list[position].title
        Picasso.get().load(list[position].image).into(holder.profilePhoto)

        holder.itemView.setOnClickListener {
            Toast.makeText(context,"Clicked",Toast.LENGTH_LONG).show()
            val i = Intent(context,YoutubeActivity::class.java)
            i.putExtra("videoId",list[position].videoId)
            context.startActivity(i)
        }
    }
}