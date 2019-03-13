package com.me.ktdemo.util

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by cs on 2019/3/13.
 */

object TurnToMarketUtils{

    /*
    包名不带 market|appStore

    三星
    索尼


    */

    fun toMarket(context: Context,appPackageName: String) {
        try {
            val uri:Uri = Uri.parse("market://details?id=$appPackageName")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }catch (e: Exception){
            println("toMarketError$e")
        }
    }

}