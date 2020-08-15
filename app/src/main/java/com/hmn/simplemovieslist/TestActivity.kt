package com.hmn.simplemovieslist

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.hmn.simplemovieslist.fragment.videofragments.FavouriteFragment
import com.hmn.simplemovieslist.fragment.videofragments.LatestVideoFragment
import com.hmn.simplemovieslist.fragment.videofragments.SettingFragment
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        init()


      nav_view_main.setNavigationItemSelectedListener(this@TestActivity)



    }


    private fun init() {

        loadFragment(LatestVideoFragment())
        bt_nav_main?.setOnNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.home_fragment_menu -> {
                    fragment = LatestVideoFragment()

                }
                R.id.favourite_farment_menu -> {
                    fragment =
                        FavouriteFragment()

                }
                R.id.setting_fragment_menu -> {
                    fragment =
                        SettingFragment()

                }
            }
            loadFragment(fragment)
        }


    }


    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.home_container, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_container, LatestVideoFragment())
            .commit()
        return true
    }

    fun openCloseNavigationDrawer(view: View) {
        if (drawer_layout_test.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_test.closeDrawer(GravityCompat.START)
        } else {
            drawer_layout_test.openDrawer(GravityCompat.START)
        }
    }





    override fun onBackPressed() {
        //mainMotion.setTransition(R.id.start)
        if (drawer_layout_test.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_test.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home_fragment_menu->{
                Toast.makeText(this,"Latest",Toast.LENGTH_LONG).show()
                supportFragmentManager.beginTransaction().replace(R.id.home_container,LatestVideoFragment()).commit()
            }
            R.id.favourite_farment_menu->{
                Log.e("@drawer","Fav")
                Toast.makeText(this,"Latest",Toast.LENGTH_LONG).show()
                supportFragmentManager.beginTransaction().replace(R.id.home_container,
                    FavouriteFragment()
                ).commit()
            }
            R.id.setting_fragment_menu->{
                Toast.makeText(this,"Latest",Toast.LENGTH_LONG).show()
                supportFragmentManager.beginTransaction().replace(R.id.home_container,
                    SettingFragment()
                ).commit()
            }
        }
        drawer_layout_test.closeDrawer(GravityCompat.START)
        return false
    }


}
