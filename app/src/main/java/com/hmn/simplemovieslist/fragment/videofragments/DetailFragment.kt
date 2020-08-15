package com.hmn.simplemovieslist.fragment.videofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.TestActivity
import com.hmn.simplemovieslist.adapter.motionadapters.MotionAdapter
import com.hmn.simplemovieslist.fragment.motionFragments.MainMotionFragment
import com.hmn.simplemovieslist.fragment.motionFragments.MotionFragment
import com.hmn.simplemovieslist.viewmodel.FViewModelImplement


class DetailFragment : Fragment() {
    lateinit var mViewModel: FViewModelImplement
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        recyclerView = view.findViewById(R.id.recycler_detail)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_detail)
        toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbar.title = "All Latest Movies"
        toolbar.setNavigationOnClickListener {
            val activity = activity as TestActivity
            activity.onSupportNavigateUp()

        }
        initRecycler()
        return view





    }

    private fun initRecycler(){

        mViewModel = ViewModelProviders.of(this).get(FViewModelImplement::class.java)
        mViewModel.getAllLatest().observe(requireActivity(), Observer {
            val list = it!!

            val adapter = MotionAdapter(requireContext(),callback = {
                replaceMotionFragment(it)
            },list = list,size = list.size)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = GridLayoutManager(requireContext(),3)



        })

    }


    private fun replaceMotionFragment(url: String) {
        val fr = fragmentManager?.beginTransaction()
        fr!!.replace(R.id.detail_container, MainMotionFragment.newInstance(url)).commit() // .addToBackStack(null)


    }




}