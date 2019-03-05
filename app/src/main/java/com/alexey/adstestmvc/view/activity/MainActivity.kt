package com.alexey.adstestmvc.view.activity

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.alexey.adstestmvc.R
import com.alexey.adstestmvc.view.fragment.ParentFragment
import com.alexey.adstestmvc.view.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , BaseFragment.OnFragmentListener{

    lateinit var drawerView : View

    override fun buttonFabClicked() {
        for(fragment in supportFragmentManager.fragments) {
            (fragment as BaseFragment).updateTime()
            for(childFragment in fragment.childFragmentManager.fragments) {
                (childFragment as BaseFragment).updateTime()
            }
        }

        updateTime(drawerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerView = nav_view.getHeaderView(0)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container1, ParentFragment.newInstance())
                .add(R.id.container2, ParentFragment.newInstance())
                .commit()
        }

        drawerView.apply {
            updateTime(this)

            findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { _ ->
                buttonFabClicked()
            }
        }
    }

    fun updateTime(view: View) {
        view.apply {
            findViewById<TextView>(R.id.textViewTimer1).text = String.format(getString(R.string.timer1), System.currentTimeMillis())
            findViewById<TextView>(R.id.textViewTimer2).text = String.format(getString(R.string.timer2), System.currentTimeMillis())
            findViewById<TextView>(R.id.textViewTimer3).text = String.format(getString(R.string.timer3), System.currentTimeMillis())
            findViewById<TextView>(R.id.textViewTimer4).text = String.format(getString(R.string.timer4), System.currentTimeMillis())
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
