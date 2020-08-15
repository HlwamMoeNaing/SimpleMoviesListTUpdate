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
import com.hmn.simplemovieslist.adapter.motionadapters.PopulerMotionAdapter
import com.hmn.simplemovieslist.fragment.motionFragments.MainMotionFragment
import com.hmn.simplemovieslist.viewmodel.FViewModelImplement
import kotlinx.android.synthetic.main.fragment_populer_detail.*


class PopulerDetailFragment : Fragment() {
    lateinit var mViewModel: FViewModelImplement
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_populer_detail, container, false)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_popular_detail)
        toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbar.title = "All Popular Movies"
        toolbar.setNavigationOnClickListener {
            val acitvity = activity as TestActivity
            acitvity.onSupportNavigateUp()

        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initPopulerRecycler()
        super.onViewCreated(view, savedInstanceState)
    }
    fun initPopulerRecycler(){
        mViewModel = ViewModelProviders.of(this).get(FViewModelImplement::class.java)
        mViewModel.getAllPopulerFromEntity().observe(requireActivity(), Observer {
            val list =it!!
            // val recy = view?.findViewById<RecyclerView>(R.id.rv_latest_fragment_2_populer)
            recycler_popular_detail.apply {
                adapter = PopulerMotionAdapter(requireContext(),
                    callback = {
                        replacePopulerMotionFragment(it)
                    },list = list,size = list.size
                )
                layoutManager = GridLayoutManager(requireContext(),3)
            }

        })
    }


    private fun replacePopulerMotionFragment(url: String) {
        val fr = fragmentManager?.beginTransaction()
        fr!!.replace(R.id.popular_container, MainMotionFragment.newInstance(url)).commit()//addToBackStack(null).

    }


}