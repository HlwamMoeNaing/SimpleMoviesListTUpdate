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
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.TestActivity
import com.hmn.simplemovieslist.adapter.motionadapters.TopMotionAdapter
import com.hmn.simplemovieslist.fragment.motionFragments.MainMotionFragment
import com.hmn.simplemovieslist.viewmodel.FViewModelImplement
import kotlinx.android.synthetic.main.fragment_top_detail.*

class TopDetailFragment : Fragment() {

    lateinit var mViewModel: FViewModelImplement

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_detail, container, false)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_top_detail)
        toolbar.title = "All Top Movies"
        toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbar.setNavigationOnClickListener {
            val activity = activity as TestActivity
            activity.onSupportNavigateUp()
           
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initTopRecycler()
        super.onViewCreated(view, savedInstanceState)
    }
    fun initTopRecycler(){
        mViewModel = ViewModelProviders.of(this).get(FViewModelImplement::class.java)
        mViewModel.getAllTop().observe(requireActivity(), Observer {
            val list =it!!
            // val recy = view?.findViewById<RecyclerView>(R.id.rv_latest_fragment_2_populer)
            recycler_top_detail.apply {
                adapter = TopMotionAdapter(requireContext(),
                    callback = {
                        replaceTopMotionFragment(it)
                    },list = list,size = list.size
                )
                layoutManager = GridLayoutManager(requireContext(),3)
            }

        })
    }


    private fun replaceTopMotionFragment(url: String) {
        val fr = fragmentManager?.beginTransaction()
        fr!!.replace(R.id.top_container, MainMotionFragment.newInstance(url)).commit()//addToBackStack(null).


    }
}