package com.me.ktdemo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.me.ktdemo.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    companion object {
        var url: String=""
        fun startActivity(context: Context?,url: String){
            val intent = Intent(context,WebActivity::class.java)
            intent.putExtra("URL",url);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            if (Build.VERSION.SDK_INT>21)context.startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(context as Activity,"URL").toBundle())
            context?.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        initView()
    }

    private fun initView() {
        url = intent.getStringExtra("URL")
        println("url=> $url")
        webView.loadUrl(url)
    }
}
