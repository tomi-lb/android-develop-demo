package com.tomi.develop.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.tomi.develop.R
import com.tomi.develop.base.BaseFragmentAdapter
import com.tomi.develop.ui.fragment.TabLayoutFragA
import com.tomi.develop.ui.fragment.TabLayoutFragB
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity : AppCompatActivity() {
    private val tabList = ArrayList<String>()
    private val fragments = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        toolbar.setNavigationOnClickListener { finish() }
        tabList.add("热门")
        tabList.add("关注")
        fragments.add(TabLayoutFragA.getInstance())
        fragments.add(TabLayoutFragB.getInstance())

        view_pager.adapter = BaseFragmentAdapter(supportFragmentManager, fragments, tabList)
        tab_layout.setupWithViewPager(view_pager)
    }
}
