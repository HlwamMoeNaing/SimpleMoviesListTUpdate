package com.hmn.simplemovieslist.adapter.motionadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.room.entity.FavouriteEntity
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.room.DatabaseL
import com.hmn.simplemovieslist.room.entity.LatestEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_item.view.*

class MotionAdapter(val context: Context,
    private val callback: ((String) -> Unit?)? = null, val list: List<LatestEntity>,val size:Int
) :
    RecyclerView.Adapter<MotionAdapter.ViewHoler>() {
    class ViewHoler(view: View) : RecyclerView.ViewHolder(view) {

        val btnFav = view.findViewById<ImageView>(R.id.imageButton_fav)
        fun bind(item: LatestEntity) {
            var url = item.url
            if (url.contains("hqdefault.jpg"))
                url = url.replace("hqdefault.jpg", "mqdefault.jpg")
            Picasso.get().load(url).resize(120,120).into(itemView.image_main)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler =
        ViewHoler(
            LayoutInflater.from(context).inflate(R.layout.main_item,  parent, false)
        )

    override fun getItemCount(): Int {
    return size
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        list[position].also { item ->
            holder.bind(item)

            holder.itemView.setOnClickListener {
               // you ar reason
                callback?.invoke(item.title)
                callback?.invoke("207X6DTY4LY")
            }
        }

        if (DatabaseL.getDatabase(context).favouriteDao().isFavorite(list[position].id) == 1)
            holder.btnFav.setImageResource(R.drawable.ic_baseline_white)
        else
            holder.btnFav.setImageResource(R.drawable.ic_baseline_favorite_white)

        holder.btnFav.setOnClickListener {
            if (DatabaseL.getDatabase(context).favouriteDao().isFavorite(list[position].id) != 1){
                addOrRemoveFavourite(list[position],true)
                holder.btnFav.setImageResource(R.drawable.ic_baseline_white)

            }else{
                addOrRemoveFavourite(list[position],false)
                holder.btnFav.setImageResource(R.drawable.ic_baseline_favorite_white)
            }

        }


    }


    private fun addOrRemoveFavourite(latestEntity: LatestEntity, isAdd:Boolean) {

        val id = latestEntity.id
        val title = latestEntity.title
        val desc = latestEntity.desc
        val url = latestEntity.url
        val favouriteEntity =
            FavouriteEntity(
                id,
                title,
                desc,
                url
            )
        if (isAdd)
            DatabaseL.getDatabase(context).favouriteDao().insertFavourite(favouriteEntity)
        else
            DatabaseL.getDatabase(context).favouriteDao().deleteFavourite(favouriteEntity)



    }
}
