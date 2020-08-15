package com.hmn.simplemovieslist.adapter.motionadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.room.entity.PopularFavouriteEntity
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.room.DatabaseL
import com.hmn.simplemovieslist.room.entity.PopulerEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.populer_list.view.*

class PopulerMotionAdapter(val context: Context,private val callback: ((String) -> Unit?)? = null,
                           val list: List<PopulerEntity>,
val size:Int):RecyclerView.Adapter<PopulerMotionAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val btnFav = view.findViewById<ImageView>(R.id.imageButton_fav_popular)

        fun bind(item: PopulerEntity) {
            var url = item.url
            if (url.contains("hqdefault.jpg"))
                url = url.replace("hqdefault.jpg", "mqdefault.jpg")
            Picasso.get().load(url).resize(120,120).into(itemView.image_popular)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.populer_list, parent, false)
        )

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list[position].also { item ->
            holder.bind(item)

            holder.itemView.setOnClickListener {
                // what is api


                callback?.invoke(item.title)
                callback?.invoke("OVvTv9Hy91Q")
            }
        }

       if (DatabaseL.getDatabase(context).favouriteDao().isPopularFav(list[position].id) == 1)
         holder.btnFav.setImageResource(R.drawable.popular_favourite_full)
        else
           holder.btnFav.setImageResource(R.drawable.populer_favourite_boarder)

        holder.btnFav.setOnClickListener {
            if (DatabaseL.getDatabase(context).favouriteDao().isPopularFav(list[position].id) != 1){
                addOrRemoveFavourite(list[position],true)
                holder.btnFav.setImageResource(R.drawable.popular_favourite_full)

            }else{
                addOrRemoveFavourite(list[position],false)
                holder.btnFav.setImageResource(R.drawable.populer_favourite_boarder)
            }

        }



    }

    private fun addOrRemoveFavourite(populerEntity: PopulerEntity,isAdd:Boolean) {

        val id = populerEntity.id
        val title = populerEntity.title
        val desc = populerEntity.desc
        val url = populerEntity.url
       val favouriteEntity =
           PopularFavouriteEntity(
               id,
               title,
               desc,
               url
           )
        if (isAdd)
            DatabaseL.getDatabase(context).favouriteDao().insertPopularFavourite(favouriteEntity)
        else
            DatabaseL.getDatabase(context).favouriteDao().deletePopularFav(favouriteEntity)



    }
}