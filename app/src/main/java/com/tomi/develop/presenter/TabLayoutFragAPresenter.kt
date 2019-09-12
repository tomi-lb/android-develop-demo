package com.tomi.develop.presenter

import com.tomi.develop.base.BasePresenter
import com.tomi.develop.contract.TabLayoutFragAContract
import com.tomi.develop.util.Constant.Companion.KAIYAN_URL
import com.tomi.develop.util.IRetrofitRequest
import com.tomi.develop.util.log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by tomi on 2019/9/12
 */
class TabLayoutFragAPresenter : BasePresenter<TabLayoutFragAContract.View>(), TabLayoutFragAContract.Presenter {

    override fun getDatas() {
        try {
            var retrofit = Retrofit.Builder().baseUrl(KAIYAN_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            var request = retrofit.create(IRetrofitRequest::class.java)
            var call = request.getCategory()

            call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        it.forEach {
                            log("name is " + it.name)
                        }
                        mView?.apply {
                            //表示object不为null的条件下，才会去执行apply,let等函数体
                            updateUI(it)
                        }
                    }
        } catch (e: Exception) {
            log("Exception " + e.printStackTrace())
        }
    }
}