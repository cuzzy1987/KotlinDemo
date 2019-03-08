package com.me.ktdemo.ui


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.me.ktdemo.R
import com.me.ktdemo.adapter.ViewPagerAdapter
import com.me.ktdemo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : BaseFragment() ,TabLayout.OnTabSelectedListener{




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_home, container, false)

    override fun initView() {
        tabLayout.addOnTabSelectedListener(this)
        setTab()
        setItem()
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }

    private fun setItem() {
        tabLayout.getTabAt(0)?.customView = getTabView(0)
        tabLayout.getTabAt(1)?.customView = getTabView(1)
    }

    private fun setTab() {
        val fragmentList: List<Fragment> = listOf(ListFragment.newInstance("news"),ListFragment.newInstance("voice"))
        viewPager.adapter = ViewPagerAdapter(fragmentList,activity!!.supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

    }

    fun getTabView(position: Int): View{
        val view: View = LayoutInflater.from(context).inflate(R.layout.tab_item_layout,null) as View
        val titleTv: TextView = view.findViewById(R.id.titleTv) as TextView
        val iconIv: ImageView = view.findViewById(R.id.iconIv) as ImageView
        iconIv.visibility = View.GONE
        when(position){
            0 ->{
                titleTv.text = "看得见"
                iconIv.setBackgroundResource(R.drawable.index)
            }
            1 ->{
                titleTv.text="听得出"
                iconIv.setBackgroundResource(R.drawable.service)
            }

            else -> print("-=hEEh=-")
        }
        return view
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {}
    override fun onTabSelected(tab: TabLayout.Tab?) {
        viewPager.currentItem = tab!!.position
    }
    override fun onTabReselected(tab: TabLayout.Tab?) {}
}
