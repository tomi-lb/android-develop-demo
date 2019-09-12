package com.tomi.develop.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.tomi.develop.R
import com.tomi.develop.base.BaseFragment
import com.tomi.develop.contract.TabLayoutFragAContract
import com.tomi.develop.model.TabLayoutFragABean
import com.tomi.develop.presenter.TabLayoutFragAPresenter
import com.tomi.develop.ui.adapter.TabLayoutFragAAdapter
import com.tomi.develop.util.log
import kotlinx.android.synthetic.main.frag_tablayout_a.*

class TabLayoutFragA : BaseFragment<TabLayoutFragAContract.View, TabLayoutFragAPresenter>(), TabLayoutFragAContract.View {
    override fun updateUI(data: ArrayList<TabLayoutFragABean.Category>) {
        //get data ok

//        var contentList = ArrayList<String>()
//        for (index in 1..10) {
//            contentList.add(index.toString())
//        }

        rv_frag_a.layoutManager = LinearLayoutManager(activity)
        rv_frag_a.adapter = TabLayoutFragAAdapter(TabLayoutFragABean(data))
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun getInstance(): TabLayoutFragA {
            val fragment = TabLayoutFragA()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayout(): Int {
        return R.layout.frag_tablayout_a
    }

    override fun createPresenter(): TabLayoutFragAPresenter {
        return TabLayoutFragAPresenter()
    }

    override fun initFrag() {
        smart_refresh_layout.setOnRefreshListener {
            log("refreshing")
            it.finishRefresh(2000, true, false)
        }

        smart_refresh_layout.setOnLoadMoreListener {
            log("loading more")
            it.finishLoadMore(200, false, false)
        }
        mPresenter?.getDatas()
    }
}