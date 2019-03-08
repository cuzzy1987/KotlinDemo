package com.me.ktdemo.network

import com.google.gson.Gson
import com.me.ktdemo.entity.DataList
import com.me.ktdemo.entity.GankNews
import com.me.ktdemo.entity.VoiceFMBean

/**
 * Created by cs on 2019/2/28.
 */
class DataLoader {

   fun getGankNewsList(data: String): List<GankNews> {
       val url = Request.BaseGankUrl+data
       return Gson().fromJson(Request(url).run(), DataList::class.java).results
   }

    fun getVoiceList(data: String): List<VoiceFMBean>{
        val url = Request.BaseVoiceUlr+data
        return Gson().fromJson(Request(url).run(),DataList::class.java).data
    }
}