package com.me.ktdemo.callback

import com.me.ktdemo.entity.GankNews

/**
 * Created by cs on 2019/3/1.
 */
interface GankNewsItemClickListener {
    fun onItemClickListener(news: GankNews)
}