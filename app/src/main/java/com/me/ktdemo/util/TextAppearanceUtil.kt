package com.me.ktdemo.util

import android.content.Context
import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.TextAppearanceSpan
import com.me.ktdemo.R

/**
 * Created by cs on 2019/3/4.
 */
object TextAppearanceUtil {

    fun setTextDescRed( context: Context?, value: String, desc: String):SpannableStringBuilder{
        val spanString = SpannableStringBuilder(value+desc)
        spanString.setSpan(ForegroundColorSpan(Color.RED),value.length,spanString.length,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanString.setSpan(TextAppearanceSpan(context, R.style.text_18sp),0,value.length,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spanString
    }

}