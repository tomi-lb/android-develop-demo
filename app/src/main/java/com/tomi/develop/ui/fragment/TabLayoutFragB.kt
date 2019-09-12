package com.tomi.develop.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tomi.develop.R

/**
 * Created by tomi on 2019/9/3
 */

class TabLayoutFragB : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.frag_tablayout_b, null)
    }

    companion object {
        fun getInstance(): TabLayoutFragB {
            val fragment = TabLayoutFragB()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
//    override fun getLayout(): Int {
//        return R.layout.frag_tablayout_b
//    }
//
//    override fun createdView() {
//
//    }
}