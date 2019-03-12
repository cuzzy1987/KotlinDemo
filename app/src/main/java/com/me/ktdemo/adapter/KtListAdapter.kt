package com.me.ktdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.me.ktdemo.R
import com.me.ktdemo.entity.GankNews
import com.me.ktdemo.entity.VoiceFMBean
import kotlinx.android.synthetic.main.item_list_layout.view.*

/**
 * Created by cs on 2019/2/27.
 */
class KtListAdapter(val items: List<Any>,val mContext:Context?,val onItemClickListener:(Any)->Unit ) : RecyclerView.Adapter<KtListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int):
            ViewHolder = ViewHolder(View.inflate(viewGroup.context, R.layout.item_list_layout,null),onItemClickListener)

    override fun getItemCount():
            Int = items.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        print("-=there=-")
        println("item.toString ==> ${items[position]}")
        val item = items[position]
        viewHolder.bind(item)
        if (item is VoiceFMBean)Glide.with(mContext).load(item.cover).into(viewHolder.view.iv)
    }

    /*fun setData(datas: ArrayList<Any>){
//        items.addAll(datas)
        notifyDataSetChanged()
    }
*/
    class ViewHolder(val view :View,private val onItemClickListener: (Any)->Unit):RecyclerView.ViewHolder(view){
        // -=xiu=-
        fun bind(item: Any){ // 避免总是使用it关键字造成冲突
            if (item is GankNews){
                view.titleTV.text = item.desc
                view.descTv.text = item.type
            }else if(item is VoiceFMBean){
                view.titleTV.text = item.speak
                view.descTv.text = item.title
            }
            view.layout.setOnClickListener {
                println("click")
                onItemClickListener(item) //
            }
        }

    }



}