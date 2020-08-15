package com.hmn.simplemovieslist.fragment.motionFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.MergeAdapter
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.TestActivity

import com.hmn.simplemovieslist.nested_recycler.HorizontalAdapter
import com.hmn.simplemovieslist.nested_recycler.LatestSuggAdapter
import com.hmn.simplemovieslist.nested_recycler.WidgetAdapter
import com.hmn.simplemovieslist.viewmodel.FViewModelImplement
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

import kotlinx.android.synthetic.main.activity_test.*

import kotlinx.android.synthetic.main.fragment_motion.*
import kotlin.math.abs


class MotionFragment : Fragment() {

    lateinit var mViewModel: FViewModelImplement
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_motion, container, false)
        val playButtom = view.findViewById<ImageView>(R.id.image_play)
        val clear: ImageView = view.findViewById<ImageView>(R.id.image_clear)
        clear.setOnClickListener {
            fragmentManager!!.beginTransaction().remove(this).commit()
        }


        var isPlaying: Boolean = false
        val youtubePlayer = view.findViewById<YouTubePlayerView>(R.id.top_image)

        lifecycle.addObserver(youtubePlayer)
        youtubePlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {

            override fun onReady(youTubePlayer: YouTubePlayer) {

                playButtom.setOnClickListener({ view ->
                    if (isPlaying) youTubePlayer.pause() else youTubePlayer.play()
                    isPlaying = !isPlaying
                })

                clear.setOnClickListener({ view ->
//                    if (!isPlaying) youTubePlayer.play() else youTubePlayer.pause()
//                    isPlaying = !isPlaying



                })

            }
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        mViewModel = ViewModelProviders.of(this).get(FViewModelImplement::class.java)
//        mViewModel.getAllPopulerFromEntity().observe(viewLifecycleOwner, Observer {
//            val li = it!!
//            recyclerView.apply {
//                adapter = PopulerAdapter(requireContext(), li, li.size)
//                layoutManager =
//                    LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
//            }
//
//
//        })
//
//        mViewModel.getAllTop().observe(viewLifecycleOwner, Observer {
//            val list = it!!
//            rv_test.apply {
//                adapter = TopAdapter(requireContext(), list, list.size)
//                layoutManager =
//                    LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
//            }
//        })

        mViewModel = ViewModelProviders.of(this).get(FViewModelImplement::class.java)

        mViewModel.getAllTop().observe(viewLifecycleOwner, Observer {
            val list = it
            val horizontalAdapter = HorizontalAdapter(requireContext(), list)
            val widgetAdapter = WidgetAdapter(requireContext())
            val latestSuggAdapter = LatestSuggAdapter(requireContext())
            val merg = MergeAdapter(widgetAdapter, horizontalAdapter,latestSuggAdapter)
            recyclerBlah.adapter = merg
        })

        videoMotionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                (activity as TestActivity).also {
                it.mainMotion.progress = abs(p3)

                }


            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {}

        })
        videoMotionLayout.transitionToEnd()

    }



}
