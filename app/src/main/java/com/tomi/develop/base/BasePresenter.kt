package com.tomi.develop.base

/**
 * Created by tomi on 2019/8/27
 * 这里主要是定义V和P的关联及解耦方法
 * 可以扩展一些第三方库与Activity的关联解耦操作，如Rxjava2的CompositeDisposabled等
 */
open class BasePresenter<T : IBaseView> : IPresenter<T> {
    var mView : T? = null

    override fun attachView(mView: T) {
        this.mView = mView
    }

    override fun detachView() {
        mView = null
    }

    fun isViewAttach() : Boolean {
        return mView != null
    }
}