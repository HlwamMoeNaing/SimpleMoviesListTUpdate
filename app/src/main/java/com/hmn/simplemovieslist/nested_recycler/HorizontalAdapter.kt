package com.hmn.simplemovieslist.nested_recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.room.entity.TopEntity

class HorizontalAdapter(var context: Context, val list: List<TopEntity>) :
    RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val horizontalImageRecycler = view.findViewById<RecyclerView>(R.id.images_recycler)
        var imageAdapter: ImageAdapter? = null

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HorizontalAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_horizontal_recycler, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: HorizontalAdapter.ViewHolder, position: Int) {
        setUpImageRecyclerView(holder)
    }


    fun setUpImageRecyclerView(holder: ViewHolder) {
        holder.imageAdapter = ImageAdapter(context)
        holder.horizontalImageRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            adapter = holder.imageAdapter
        }
        holder.imageAdapter?.addData(list)
//val list = arrayListOf<TopEntity>()

    }
}