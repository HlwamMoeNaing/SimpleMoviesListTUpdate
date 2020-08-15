package com.hmn.simplemovieslist.adapter.motionadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.room.entity.TopFavouriteEntity
import com.hmn.simplemovieslist.room.DatabaseL
import com.hmn.simplemovieslist.room.entity.TopEntity
import com.squareup.picasso.Picasso

class TopMotionAdapter(val context: Context,private val callback: ((String) -> Unit?)? = null,

                        val list: List<TopEntity>,
                       val size:Int
): RecyclerView.Adapter<TopMotionAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.image_top)
        val favBtn = view.findViewById<ImageView>(R.id.imageButton_fav_top)
        fun bind(item: TopEntity) {
            var url = item.url
            if (url.contains("hqdefault.jpg"))
                url = url.replace("hqdefault.jpg", "mqdefault.jpg")
            Picasso.get().load(url).resize(120,120).into(image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.top_item, parent, false)
        )

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list[position].also { item ->
            holder.bind(item)

            holder.itemView.setOnClickListener {
                callback?.invoke(item.title)
                callback?.invoke("MFptcZb4YwM") // life of
            }
        }
        if (DatabaseL.getDatabase(context).favouriteDao().isTopFavorite(list[position].id) == 1)
            holder.favBtn.setImageResource(R.drawable.top_favourite_full)
        else
            holder.favBtn.setImageResource(R.drawable.top_favourite_boarder)

        holder.favBtn.setOnClickListener {
            if (DatabaseL.getDatabase(context).favouriteDao().isTopFavorite(list[position].id) !=1){
                addOrRemove(list[position],true)
                holder.favBtn.setImageResource(R.drawable.top_favourite_full)
            }else{
                addOrRemove(list[position],false)
                 holder.favBtn.setImageResource(R.drawable.top_favourite_boarder)

            }
        }
    }

    private fun addOrRemove(topEntity:TopEntity,isAdd:Boolean){
        val id = topEntity.id
        val title = topEntity.title
        val desc = topEntity.desc
        val url = topEntity.url
        val favourite = TopFavouriteEntity(
            id,
            title,
            desc,
            url
        )
        if (isAdd)
            DatabaseL.getDatabase(context).favouriteDao().insertTopFavourite(favourite)
        else
            DatabaseL.getDatabase(context).favouriteDao().deleteTopFavourite(favourite)
    }
}