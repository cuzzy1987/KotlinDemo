package com.me.ktdemo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by cs on 2019/2/25.
 */
class ViewPagerAdapter(var list:List<Fragment>,fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    // can be init as params


    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

}