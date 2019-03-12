package com.me.ktdemo.ui


import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.me.ktdemo.R
import com.me.ktdemo.adapter.KtListAdapter
import com.me.ktdemo.base.BaseFragment
import com.me.ktdemo.entity.GankNews
import com.me.ktdemo.network.DataLoader
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NewsListFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_news_list, container, false)


    override fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        getNewsList()
    }

    private fun getNewsList()  = doAsync{
        val news: List<GankNews> = DataLoader().getGankNewsList("data/all/20/2")
        uiThread { recyclerView.adapter = KtListAdapter(news,context){
            if (it is GankNews){
                var intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_SUBJECT,it.who)
                intent.putExtra(Intent.EXTRA_TEXT,it.desc)
                intent = Intent.createChooser(intent,"分享")
                context!!.startActivity(intent)
            }
            print("item => ${it}")
        } }
    }


}
