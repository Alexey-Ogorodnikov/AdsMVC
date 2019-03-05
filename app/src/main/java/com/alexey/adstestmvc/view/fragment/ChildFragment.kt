package com.alexey.adstestmvc.view.fragment

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alexey.adstestmvc.R
import com.alexey.adstestmvc.view.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_child.*
import kotlinx.android.synthetic.main.main_item.*

class ChildFragment : BaseFragment() {

    companion object {
        val TAG = ChildFragment::class.toString()
        fun newInstance() = ChildFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_child, container, false)
    }

    override fun onStart() {
        super.onStart()
        main_layout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorOrange))
        main_item_view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorBlue))
    }

    override fun fabClick() {
        super.fabClick()
        main_item_view.apply {
            findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { _ ->
                mCallback?.buttonFabClicked()
            }
        }
    }
    override fun updateTime(){
        super.updateTime()
        main_item_view.apply {
            findViewById<TextView>(R.id.textViewTimer1).text = String.format(getString(R.string.timer1), System.currentTimeMillis())
            findViewById<TextView>(R.id.textViewTimer2).text = String.format(getString(R.string.timer2), System.currentTimeMillis())
            findViewById<TextView>(R.id.textViewTimer3).text = String.format(getString(R.string.timer3), System.currentTimeMillis())
            findViewById<TextView>(R.id.textViewTimer4).text = String.format(getString(R.string.timer4), System.currentTimeMillis())
        }
    }
}