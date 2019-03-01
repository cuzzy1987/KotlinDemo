package com.me.ktdemo.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.me.ktdemo.R
import com.me.ktdemo.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),TabLayout.OnTabSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        tabLayout.addOnTabSelectedListener(this)
        setTab()
        setItem()
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }

    private fun setItem() {
        tabLayout.getTabAt(0)?.customView = getTabView(0)
        tabLayout.getTabAt(1)?.customView = getTabView(1)
        tabLayout.getTabAt(2)?.customView = getTabView(2)
    }

    private fun setTab() {
        val indexFragment = IndexFragment()
        val homeFragment = HomeFragment()
        val mineFragment = MineFragment()
        val fragmentList: List<Fragment> = listOf(indexFragment,homeFragment,mineFragment)
        viewPager.adapter = ViewPagerAdapter(fragmentList,this.supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

    }


    override fun onTabSelected(tab: TabLayout.Tab?) {
        print("tab position -> ")
        viewPager.currentItem = tab!!.position
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }

    fun getTabView(position: Int): View{
        val view: View = LayoutInflater.from(this).inflate(R.layout.tab_item_layout,null) as View
        val titleTv: TextView = view.findViewById(R.id.titleTv) as TextView
        val iconIv: ImageView = view.findViewById(R.id.iconIv) as ImageView
        when(position){
            0 ->{
                titleTv.text = "首页"
                iconIv.setBackgroundResource(R.drawable.index)
            }
            1 ->{
                titleTv.text="内容"
                iconIv.setBackgroundResource(R.drawable.service)
            }
            2 -> {
                titleTv.text="我的"
                iconIv.setBackgroundResource(R.drawable.mine)
            }
            else -> print("-=hEEh=-")
        }
        return view
    }

}
