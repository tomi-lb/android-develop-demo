package com.tomi.develop.contract

import com.tomi.develop.base.IBaseView
import com.tomi.develop.base.IPresenter
import com.tomi.develop.model.TabLayoutFragABean

/**
 * Created by tomi on 2019/9/12
 */
interface TabLayoutFragAContract {
    interface View : IBaseView {
        fun updateUI(data : ArrayList<TabLayoutFragABean.Category>)
    }

    interface Presenter : IPresenter<View> {
        fun getDatas()
    }
}