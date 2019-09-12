package com.tomi.develop.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tomi.develop.R
import com.tomi.develop.util.Constant
import com.tomi.develop.util.snackbar
import kotlinx.android.synthetic.main.activity_material.*

class MaterialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        webview.loadUrl(Constant.MATERIAL_ACTIVITY_WEBVIEW_URL)

        //设置一下属性，解决imageview为沉浸状态时，Toolbar收起Title位置显示不正确的问题
        toolbar.post {
            toolbar.titleMarginStart = 0
        }

        toolbar.setNavigationOnClickListener {
            finish()
        }

        floating_action_button.setOnClickListener {
            it.isSelected = !it.isSelected
            if (it.isSelected) {
                collapsing_toolbar_layout.snackbar("snackbar")
            }
        }
    }
}
