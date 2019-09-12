package com.tomi.develop.base

/**
 * Created by tomi on 2019/8/27
 */
interface IPresenter<V : IBaseView> {

    fun attachView(mView : V)

    fun detachView()
}