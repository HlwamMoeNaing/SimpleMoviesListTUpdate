package com.hmn.simplemovieslist.nested_recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.R

class WidgetAdapter(var context: Context):RecyclerView.Adapter<WidgetAdapter.ViewHolder>() {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.widget_ani_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
       return 1
    }

    override fun onBindViewHolder(holder: WidgetAdapter.ViewHolder, position: Int) {

    }
}