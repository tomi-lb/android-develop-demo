package com.tomi.develop.contract

import com.tomi.develop.base.IBaseView
import com.tomi.develop.base.IPresenter

/**
 * Created by tomi on 2019/8/27
 */
interface MainContract {
    interface View : IBaseView {
        fun updateUI(result : String)
    }

    interface Presenter : IPresenter<View> {
        fun commit()
    }
}