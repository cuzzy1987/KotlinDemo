package com.me.ktdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.me.ktdemo.R
import com.me.ktdemo.entity.GankNews
import kotlinx.android.synthetic.main.item_list_layout.view.*

/**
 * Created by cs on 2019/2/27.
 */
class KtListAdapter(val items: List<GankNews>,val context:Context?) : RecyclerView.Adapter<KtListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int):
            ViewHolder = ViewHolder(View.inflate(viewGroup.context, R.layout.item_list_layout,null))

    override fun getItemCount():
            Int = items.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val news: GankNews = items[position]
        viewHolder.view.titleTV.text = news.desc
        viewHolder.view.descTv.text = news.type
//        Glide.with(context).load(news.)
    }

    class ViewHolder(val view :View):RecyclerView.ViewHolder(view)
}