package com.hmn.simplemovieslist.fragment.videofragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.utils.DarkTheme


class SettingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_setting, container, false)
        val share = view.findViewById<LinearLayout>(R.id.btn_share)
        val appearance = view.findViewById<LinearLayout>(R.id.bt_mode)
        val about = view.findViewById<LinearLayout>(R.id.btn_about)


        share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setData(Uri.parse("mailto:"))
            val arrayList = ArrayList<String>()
            arrayList.add("xyz@gmail.com")
            arrayList.add("abc@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL,arrayList)
            intent.putExtra(Intent.EXTRA_SUBJECT,"")
            intent.putExtra(Intent.EXTRA_TEXT,"Sending apk-debug file")
            intent.setType("message/rfc822")
            val chooser = Intent.createChooser(intent,"Send Email")
            startActivity(chooser)

        }

        about.setOnClickListener {
            val mAlertDialogBuilder = AlertDialog.Builder(requireContext())
            mAlertDialogBuilder.setTitle("This is About... ")
            mAlertDialogBuilder.setMessage("Blah Blah")
            mAlertDialogBuilder.setCancelable(false)
            mAlertDialogBuilder.setPositiveButton("Ok"){_,_->}
            val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()


        }

        fun View.setSelectedIfDarkTheme() {
            isSelected = DarkTheme.isEnabled(context)
        }
        appearance.setSelectedIfDarkTheme()
        appearance.setOnClickListener {
            DarkTheme.apply(enabled = it.isSelected.not())
            it.setSelectedIfDarkTheme()
        }
        return view
    }




}