package com.me.ktdemo.network

import java.net.URL

/**
 * Created by cs on 2019/2/28.
 */
class Request(val url: String){

    companion object {
        val BaseUrl = "http://gank.io/api/"
    }

    fun run(): String{
        val resultStr = URL(url).readText()
        return resultStr
    }
}