package com.alexey.adstestmvc.view.fragment.base

import android.content.Context
import android.support.v4.app.Fragment
import com.alexey.adstestmvc.R
import kotlinx.android.synthetic.main.main_item.*

open class BaseFragment : Fragment() {

    var mCallback: OnFragmentListener? = null

    interface OnFragmentListener {
        fun buttonFabClicked()
    }

    lateinit var mContext: Context

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context!!
        try {
            mCallback = context as OnFragmentListener?
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement OnFragmentListener")
        }
    }

    override fun onStart() {
        super.onStart()
        updateTime()
        fabClick()
    }

    open fun fabClick(){
        fab.setOnClickListener { _ ->
            mCallback?.buttonFabClicked()
        }
    }

    open fun updateTime(){
        textViewTimer1.text = String.format(getString(R.string.timer1), System.currentTimeMillis())
        textViewTimer2.text = String.format(getString(R.string.timer2), System.currentTimeMillis())
        textViewTimer3.text = String.format(getString(R.string.timer3), System.currentTimeMillis())
        textViewTimer4.text = String.format(getString(R.string.timer4), System.currentTimeMillis())
    }
}