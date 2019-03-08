package com.me.ktdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.me.ktdemo.R
import com.me.ktdemo.entity.GankNews
import com.me.ktdemo.entity.VoiceFMBean
import kotlinx.android.synthetic.main.item_list_layout.view.*

/**
 * Created by cs on 2019/2/27.
 */
class KtListAdapter(val items: List<Any>,val context:Context?,val onItemClickListener:(Any)->Unit ) : RecyclerView.Adapter<KtListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int):
            ViewHolder = ViewHolder(View.inflate(viewGroup.context, R.layout.item_list_layout,null),onItemClickListener)

    override fun getItemCount():
            Int = items.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        println("item.toString ==> ${items[position].toString()}")
        viewHolder.bind(items[position])
    }

    class ViewHolder(val view :View,private val onItemClickListener: (Any)->Unit):RecyclerView.ViewHolder(view){
        // -=xiu=-
        fun bind(it: Any){
            if (it is GankNews){
                view.titleTV.text = it.desc
                view.descTv.text = it.type
            }else if(it is VoiceFMBean){
                view.titleTV.text = it.speak
                view.descTv.text = it.title
            }

            view.layout.setOnClickListener {
                println("click")
                onItemClickListener(it)
            }
        }

    }


}