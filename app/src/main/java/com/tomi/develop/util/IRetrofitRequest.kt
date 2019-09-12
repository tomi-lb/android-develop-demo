package com.tomi.develop.util

import com.tomi.develop.model.TabLayoutFragABean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by tomi on 2019/9/12
 */
interface IRetrofitRequest {
    /**
     * 获取分类
     */
    @GET("v4/categories")
    fun getCategory(): Observable<ArrayList<TabLayoutFragABean.Category>>
}