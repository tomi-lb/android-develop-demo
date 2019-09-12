package com.tomi.develop.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by tomi on 2019/9/3
 * Fragment lifecycle =>
 * onAttach -> onCreate -> onCreateView -> onActivityCreated -> onStart ->
 * onResume -> onPause -> onStop -> onDestroyView -> onDestory -> onDetach
 */
abstract class BaseFragment<K : IBaseView, V : BasePresenter<K>> : Fragment(), IBaseView {
    var mPresenter: V? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(getLayout(), null)
    }

    //onCreateView是创建的时候调用，onViewCreated是在onCreateView后被触发的事件，前后关系
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFrag()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        mPresenter?.attachView(this as K)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
    }

    abstract fun getLayout(): Int
    abstract fun initFrag()
    abstract fun createPresenter(): V
}