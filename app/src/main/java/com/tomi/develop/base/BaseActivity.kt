package com.tomi.develop.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by tomi on 2019/8/27
 */
abstract class BaseActivity<K : IBaseView, V : BasePresenter<K>> : AppCompatActivity(), IBaseView {
    var mPresenter: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = createPresenter()
        mPresenter?.attachView(this as K)
        setContentView(getLayout())
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    abstract fun getLayout(): Int
    abstract fun createPresenter(): V
}