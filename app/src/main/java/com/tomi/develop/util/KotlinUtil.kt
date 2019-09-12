package com.tomi.develop.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.Toast

/**
 * Created by tomi on 2019/8/30
 */

fun <T> Activity.gotoActivity(cls: Class<T>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}

fun Context.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show();
}

fun Any.log(msg: String) {
    Log.d("_" + this::class.java.simpleName, msg)
}

fun View.snackbar(msg: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, msg, duration).show()
}

