package com.me.ktdemo.base

import android.os.Bundle
import android.support.v4.app.Fragment
import org.jetbrains.anko.toast

/**
 * Created by cs on 2019/3/7.
 */

abstract class BaseFragment: Fragment(){

    abstract fun initView()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    fun showToast(string: String){
//        Toast.makeText(context,string, Toast.LENGTH_SHORT).show()
        activity?.toast(string)
    }

}