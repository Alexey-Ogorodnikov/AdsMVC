package com.alexey.adstestmvc.view.fragment

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexey.adstestmvc.R
import com.alexey.adstestmvc.view.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.main_item.*

class ParentFragment : BaseFragment() {

    companion object {
        val TAG = ParentFragment::class.toString()
        fun newInstance() = ParentFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_parent, container, false)
    }

    override fun onStart() {
        super.onStart()
        main_layout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPurple))
        this.childFragmentManager.beginTransaction()
            .replace(
                R.id.container_child,
                ChildFragment.newInstance(),
                ChildFragment.TAG)
            .commit()
    }
}