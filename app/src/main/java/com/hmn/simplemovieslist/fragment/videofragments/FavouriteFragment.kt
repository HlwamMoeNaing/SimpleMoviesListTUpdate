package com.hmn.simplemovieslist.fragment.videofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.adapter.favouriteadapter.FavouriteAdapter
import com.hmn.simplemovieslist.adapter.favouriteadapter.PopularFavouriteAdapter
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.adapter.favouriteadapter.TopFavouriteAdapter
import com.hmn.simplemovieslist.room.DatabaseL


class FavouriteFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favourite, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_favourite)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        val favlist = DatabaseL.getDatabase(requireContext()).favouriteDao().getAllFavourite()
        val pFavList =DatabaseL.getDatabase(requireContext()).favouriteDao().getAllPopularFav()
        val tFavList =DatabaseL.getDatabase(requireContext()).favouriteDao().getAllTopFav()

        val favouriteAdapter =
            FavouriteAdapter(
                requireContext(),
                favlist
            )
        val popularFavouriteAdapter =
            PopularFavouriteAdapter(
                requireContext(),
                pFavList
            )
        val topFavouriteAdapter =
            TopFavouriteAdapter(
                requireContext(),
                tFavList
            )
        val mergeAdapter = MergeAdapter(favouriteAdapter,popularFavouriteAdapter,topFavouriteAdapter)
        recycler.adapter = mergeAdapter

        return view
    }






}