package com.tomi.develop.ui.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.tomi.develop.R
import com.tomi.develop.base.BaseActivity
import com.tomi.develop.contract.MainContract
import com.tomi.develop.presenter.MainPresenter
import com.tomi.develop.util.gotoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainContract.View, MainPresenter>(), MainContract.View {
    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun updateUI(result: String) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(findViewById(R.id.my_toolbar))

        btn_material.setOnClickListener {
            gotoActivity(MaterialActivity::class.java)
        }

        btn_tablayout.setOnClickListener {
            gotoActivity(TabLayoutActivity::class.java)
        }
    }
}
