package com.tomi.develop.ui.adapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.tomi.develop.R
import com.tomi.develop.model.TabLayoutFragABean
import com.tomi.develop.util.log


/**
 * Created by tomi on 2019/9/6
 * RecycleView显示多Type
 */
class TabLayoutFragAAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    lateinit var ABean: TabLayoutFragABean
    var size = 0

    companion object {
        private const val ITEM_TYPE_BANNER = 1
        private const val ITEM_TYPE_CONTENT = 2
        private const val ITEM_TYPE_FOOTER = 3
        private const val ITEM_TYPE_NAVIGATE = 4
    }

    constructor(ABean: TabLayoutFragABean) : super() {
        this.ABean = ABean
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_TYPE_BANNER ->
                HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(com.tomi.develop.R.layout.item_banner, parent, false))
            ITEM_TYPE_CONTENT ->
                ContentViewHolder(LayoutInflater.from(parent.getContext()).inflate(com.tomi.develop.R.layout.item_content, parent, false))
            ITEM_TYPE_NAVIGATE ->
                NavigateViewHolder(LayoutInflater.from(parent.getContext()).inflate(com.tomi.develop.R.layout.item_recyclerview, parent, false),
                        ABean)
            else ->
                FooterViewHolder(LayoutInflater.from(parent.getContext()).inflate(com.tomi.develop.R.layout.item_footer, parent, false))
        }
    }

    override fun getItemCount(): Int {
        size = ABean.itemList.size + 3
        return size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        log("onBindViewHolder position " + position)
        if (holder is HeaderViewHolder) {
            holder.banner.setAdapter { banner, itemView, model, position ->
                Glide.with(itemView.context)
                        .load(model)
                        .placeholder(R.drawable.ic_del)
                        .error(R.drawable.ic_del)
                        .centerCrop()
                        .dontAnimate()
                        .into(itemView as ImageView)
            }

            var imgUrls = ArrayList<String>()
            var imgTips = ArrayList<String>()
            var size = 0
            ABean.itemList.forEach continuing@{
                if (++size < 10) {
                    return@continuing
                }
                imgUrls.add(it.headerImage)
                imgTips.add(it.description)
            }

            if (imgUrls.size > 1) {
                holder.banner.setData(imgUrls, imgTips)
            }
        } else if (holder is FooterViewHolder) {

        } else if (holder is ContentViewHolder) {
            holder.tvName.text = ABean.itemList.get(position - 2).description
            Glide.with(holder.itemView.context)
                    .load(ABean.itemList.get(position - 2).headerImage)
                    .centerCrop()
                    .placeholder(R.drawable.ic_del)
                    .into(holder.ivPic)
        } else if (holder is NavigateViewHolder) {
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            position == 0 -> ITEM_TYPE_BANNER
            position == 1 -> ITEM_TYPE_NAVIGATE
            position == size - 1 -> ITEM_TYPE_FOOTER
            else -> ITEM_TYPE_CONTENT
        }
    }

    class HeaderViewHolder : RecyclerView.ViewHolder {
        val banner: BGABanner

        constructor(itemView: View) : super(itemView) {
            banner = itemView.findViewById(com.tomi.develop.R.id.banner)
        }
    }

    class ContentViewHolder : RecyclerView.ViewHolder {
        val ivPic: ImageView
        val tvName: TextView

        constructor(itemView: View) : super(itemView) {
            ivPic = itemView.findViewById(R.id.iv_content)
            tvName = itemView.findViewById(com.tomi.develop.R.id.tv_name)
        }
    }

    class FooterViewHolder : RecyclerView.ViewHolder {

        constructor(itemView: View) : super(itemView) {

        }
    }

    class NavigateViewHolder : RecyclerView.ViewHolder {
        val rvNavigate: RecyclerView
        var nameList = ArrayList<String>()
        var iconList = ArrayList<String>()

        constructor(itemView: View, ABean: TabLayoutFragABean) : super(itemView) {
            log("NavigateViewHolder init")

            run loop@{
                ABean.itemList.forEach {
                    nameList.add(it.name)
                    iconList.add(it.bgPicture)
                    if (nameList.size > 7) {
                        return@loop
                    }
                }
            }

            rvNavigate = itemView.findViewById(R.id.rv_item)
            rvNavigate.layoutManager = GridLayoutManager(itemView.context, 4, GridLayoutManager.VERTICAL, false)
            rvNavigate.adapter = NavigateAdapter(nameList, iconList)
        }
    }
}