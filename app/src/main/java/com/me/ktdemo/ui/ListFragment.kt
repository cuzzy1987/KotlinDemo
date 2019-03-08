package com.me.ktdemo.ui


import android.os.Bundle
import android.support.v4.app.Fragment
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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val FROM = "from"

/**
 * A simple [Fragment] subclass.
 *
 */
class ListFragment : BaseFragment() {

    var from: String? = null

    companion object {
        @JvmStatic
    fun newInstance(from: String): ListFragment
                =  ListFragment().apply {
            arguments = Bundle().apply {
                putString(FROM,from)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun initView() {
        arguments.let { from = it?.getString(FROM) }
        recyclerView.layoutManager = LinearLayoutManager(activity)
        getGankNewsList()
    }


    fun getGankNewsList() = doAsync{
        println("from is $from")
        val news:List<GankNews> = DataLoader().getGankNewsList("data/all/20/2")
        uiThread{
            recyclerView.adapter = KtListAdapter(news,context){
                print("item => ${it}")
                showToast(it.toString())
                if (it is GankNews)WebActivity.startActivity(context ,it.url)
            }
        }
        /*when(from){


            "news" -> {
                val news:List<GankNews> = DataLoader().getGankNewsList("data/all/20/2")
                uiThread{
                    recyclerView.adapter = KtListAdapter(news,context){
                        print("item => ${it}")
                        showToast(it.toString())
                        if (it is GankNews)WebActivity.startActivity(context ,it.url)
                    }
                }
            }
            "voice" -> {
                val item:List<VoiceFMBean> = DataLoader().getVoiceList("offset=0&speaker_id=0&tag=%E6%8A%91%E9%83%81%E7%97%87%E6%98%AF%E6%9D%A1%E9%BB%91%E7%8B%97&rows=10&key=046b6a2a43dc6ff6e770255f57328f89")
                uiThread{
                    recyclerView.adapter = KtListAdapter(item,context){
                        print("item => ${it}")
                        showToast(it.toString())
                        if (it is VoiceFMBean)WebActivity.startActivity(context ,it.url)
                    }
                }

            }
        }*/

    }

}
