package com.tomi.develop.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.tomi.develop.R

/**
 * Created by tomi on 2019/9/11
 */
class NavigateAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    val nameList: ArrayList<String>
    val iconList: ArrayList<String>

    constructor(nameList: ArrayList<String>, iconList: ArrayList<String>) : super() {
        this.nameList = nameList
        this.iconList =iconList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NavigateVH(LayoutInflater.from(parent.getContext()).inflate(com.tomi.develop.R.layout.item_navigate, parent, false))
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as NavigateVH
        h.itemName.text = nameList.get(position)
        Glide.with(h.itemView.context)
                .load(iconList.get(position))
                //.centerCrop()
                .transform(RoundedCorners(38))//圆角图片
                //.apply(RequestOptions.circleCropTransform())//圆形图片
                .placeholder(R.drawable.ic_del)
                .into(h.itemImageView)
    }

    class NavigateVH : RecyclerView.ViewHolder {
        val itemName: TextView
        val itemImageView: ImageView

        constructor(itemView: View) : super(itemView) {
            itemName = itemView.findViewById(R.id.tv_item_name)
            itemImageView = itemView.findViewById(R.id.iv_item_icon)
        }
    }
}