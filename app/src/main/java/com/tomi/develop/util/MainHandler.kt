package com.tomi.develop.util

import android.os.Handler
import android.os.Looper

/**
 * Created by tomi on 2019/8/27
 */
class MainHandler : Handler {

    constructor(looper: Looper) : super(looper)

    //懒汉模式
    companion object {
        val mInstance by lazy {
            MainHandler(Looper.getMainLooper())
        }
    }

    fun runOnUiThread(runnable: Runnable) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            runnable.run()
        } else {
            mInstance.post(runnable)
        }
    }
}