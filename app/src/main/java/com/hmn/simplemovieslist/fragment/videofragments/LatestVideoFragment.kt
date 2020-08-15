package com.hmn.simplemovieslist.fragment.videofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hmn.simplemovieslist.*
import com.hmn.simplemovieslist.adapter.motionadapters.MotionAdapter
import com.hmn.simplemovieslist.adapter.motionadapters.PopulerMotionAdapter
import com.hmn.simplemovieslist.adapter.motionadapters.TopMotionAdapter
import com.hmn.simplemovieslist.fragment.motionFragments.MainMotionFragment
import com.hmn.simplemovieslist.viewmodel.FViewModelImplement
import kotlinx.android.synthetic.main.fragment_latest_video.*


class LatestVideoFragment : Fragment() {
    lateinit var mViewModel: FViewModelImplement
    lateinit var motionAdapter:MotionAdapter

    companion object {
        fun newFragment(): LatestVideoFragment {
            return LatestVideoFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_latest_video, container, false)
        //initRecycler()
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_home)
        toolbar.title = "Home"

        val menuImg = view.findViewById<ImageView>(R.id.menu_open)
       menuImg.setOnClickListener {v->
           (activity as TestActivity) .openCloseNavigationDrawer(v)

       }





        val latest_expand = view.findViewById<Button>(R.id.latest_expand_latest)
        val popular_expand = view.findViewById<Button>(R.id.popular_expand_Latest_Frag)
        val Top_expand = view.findViewById<Button>(R.id.top_expand_latest)
        latest_expand.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.replace(R.id.home_container,
                DetailFragment()
            )
            fr.commit()

        }

        popular_expand.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.replace(R.id.home_container,
                PopulerDetailFragment()
            )
            fr.commit()

        }

        Top_expand.setOnClickListener {
            val fr = fragmentManager?.beginTransaction()
            fr!!.replace(R.id.home_container,
                TopDetailFragment()
            )
            fr.commit()


        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initLatestRecycler()
        initPopulerRecycler()
        initTopRecycler()
        super.onViewCreated(view, savedInstanceState)
    }

    fun initLatestRecycler() {
        mViewModel = ViewModelProviders.of(this).get(FViewModelImplement::class.java)
        mViewModel.getAllLatest().observe(requireActivity(), Observer {
            val list = it!!
            val latestRecy = activity!!.findViewById<RecyclerView>(R.id.latest_recyclerView)
            motionAdapter = MotionAdapter(requireContext(),callback = {
                replaceVideoFragment(it)
            },list = list,size = 3)

            latestRecy.adapter= motionAdapter
            latestRecy.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
//            latestRecy.apply {
//                adapter =
//                    MotionAdapter(requireContext(),
//                        callback = {
//                            replaceVideoFragment(it)
//                        },
//
//                        list = list,size = 3
//                    )
//                layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
//            }
        })
    }
    fun initPopulerRecycler(){
        mViewModel = ViewModelProviders.of(this).get(FViewModelImplement::class.java)
        mViewModel.getAllPopulerFromEntity().observe(requireActivity(), Observer {
            val list =it!!

            val popularRecycler = view!!.findViewById<RecyclerView>(R.id.popular_recyclerVew)
            popularRecycler.apply {
                adapter = PopulerMotionAdapter(requireContext(),
                    callback = {
                        replacePopulerMotionFragment(it)
                    },list = list,size = 3
                )
                layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
            }

        })
    }

    fun initTopRecycler(){
        mViewModel = ViewModelProviders.of(this).get(FViewModelImplement::class.java)
        mViewModel.getAllTop().observe(requireActivity(), Observer {
            val list =it!!

            top_recyclerView.apply {
                adapter = TopMotionAdapter(requireContext(),
                    callback = {
                        replaceTopMotionFragment(it)
                    },list = list,size = 3
                )
                layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
            }

        })
    }

    private fun replaceVideoFragment(url: String) {
        val fr = fragmentManager?.beginTransaction()
        fr!!.replace(R.id.container_latest, MainMotionFragment.newInstance(url))
        fr.commit()

    }

    private fun replacePopulerMotionFragment(url: String) {
        val fr = fragmentManager?.beginTransaction()
        fr!!.replace(R.id.container_latest, MainMotionFragment.newInstance(url))
        fr.commit()

        //.addToBackStack(null)

    }

    private fun replaceTopMotionFragment(url: String) {
        val fr = fragmentManager?.beginTransaction()
        fr!!.replace(R.id.container_latest, MainMotionFragment.newInstance(url))
        fr.commit()
        //.addToBackStack(null)

    }
}