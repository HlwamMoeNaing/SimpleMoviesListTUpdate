package com.hmn.simplemovieslist.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hmn.simplemovieslist.R
import com.hmn.simplemovieslist.TestActivity
import com.hmn.simplemovieslist.utils.Util
import com.hmn.simplemovieslist.utils.Util.KEY_DB_LATEST_DATE
import com.hmn.simplemovieslist.room.entity.LatestEntity
import com.hmn.simplemovieslist.room.entity.PopulerEntity
import com.hmn.simplemovieslist.room.entity.TopEntity
import com.hmn.simplemovieslist.viewmodel.FViewModelImplement
import java.text.SimpleDateFormat
import java.util.*

class SplashActivity : AppCompatActivity() {
    lateinit var mViewModel: FViewModelImplement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mSharedPreferences = getSharedPreferences("ConfigUtils", Context.MODE_PRIVATE)
        mViewModel = ViewModelProviders.of(this).get(FViewModelImplement::class.java)

        if (isConnectingToInternet(this)) {
            if (loadDBLatestDate() < SimpleDateFormat("yyyyMMdd").format(Date()).toLong()) {
                mViewModel.deleteAllTop()
                mViewModel.deleteAllPopuler()
                mViewModel.deleteAllLatest()
                mViewModel.getPopulerFromRetrofit().observe(this, Observer {
                    val list = it!!
                    for (i in list) {
                        val str = i.thumbnail.url
                        val a = StringBuffer(str)
                        a.insert(4, 's')
                        mViewModel.insertPopulerToEntity(
                            PopulerEntity(
                                0,
                                i.title,
                                i.desc,
                                i.thumbnail.url
                            )
                        )
                    }
                })
                mViewModel.getFromTopModel().observe(this, Observer {
                    val list = it!!
                    for (i in list) {
                        val str = i.thumbnail.url
                        val a = StringBuffer(str)
                        a.insert(4, 's')
                        mViewModel.insertTop(
                            TopEntity(
                                0,
                                i.title,
                                i.desc,
                                a.toString()
                            )
                        )
                    }
                })


                mViewModel.getFromModel().observe(this, Observer {
                    val list = it!!
                    for (i in list) {
                        val str = i.thumbnail.url
                        val a = StringBuffer(str)
                        //a.insert(4, 's')
                        mViewModel.insertLatest(
                            LatestEntity(
                                0,
                                i.title,
                                i.desc,
                                a.toString()
                            )
                        )
                    }
                    saveDBLatestDate(SimpleDateFormat("yyyyMMdd").format(Date()).toLong())
                    Handler().postDelayed(
                        {
                            startActivity(Intent(this, TestActivity::class.java))
                            finish()
                        },
                        2000
                    )
                })

            } else {
                Handler().postDelayed(
                    {
                        startActivity(Intent(this, TestActivity::class.java))
                        finish()
                    },
                    1000
                )


            }


        } else {
            if (isDatabaseExist()) {
                Toast.makeText(
                    this,
                    "No Internet Connection, Please access to internet", Toast.LENGTH_LONG
                ).show()
                Handler().postDelayed(
                    {
                        startActivity(Intent(this, TestActivity::class.java))
                        finish()
                    },
                    1000
                )
            } else {
                Toast.makeText(
                    this,
                    "No Internet Connection, Please access to internet", Toast.LENGTH_LONG
                ).show()
                Handler().postDelayed(
                    {
                        finish()
                    }, 1000
                )
            }
        }
    }


    fun isConnectingToInternet(context: Context): Boolean {
        val connectivity = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if (connectivity != null) {
            val info = connectivity.allNetworkInfo
            if (info != null)
                for (i in info)
                    if (i.state == NetworkInfo.State.CONNECTED) {
                        return true
                    }
        }
        return false
    }

    companion object {

        private lateinit var mSharedPreferences: SharedPreferences


        fun saveDBLatestDate(date: Long) {
            mSharedPreferences.edit().putLong(KEY_DB_LATEST_DATE, date).apply()
        }

        fun loadDBLatestDate(): Long {
            return mSharedPreferences.getLong(KEY_DB_LATEST_DATE, 0)
        }

    }


    fun isDatabaseExist(): Boolean {
        val dbFile = this.getDatabasePath(Util.DB_NAME)
        return dbFile.exists()
    }

}