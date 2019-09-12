package com.tomi.develop.model

/**
 * Created by tomi on 2019/9/9
 *
 * 数据源: http://baobab.kaiyanapp.com/api/v4/categories
 */
data class TabLayoutFragABean(val itemList: ArrayList<Category>) {
    data class Category(val name: String, val description: String, val bgPicture: String, val headerImage: String)
}