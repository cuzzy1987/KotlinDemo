package com.me.ktdemo.network

import java.net.URL

/**
 * Created by cs on 2019/2/28.
 */
class Request(val url: String){

    companion object {
        val BaseGankUrl = "http://gank.io/api/"
        val BaseVoiceUlr = "http://bapi.xinli001.com/fm2/broadcast_list.json/?"
    }

    fun run(): String{
        val resultStr = URL(url).readText()
        return resultStr
    }
}