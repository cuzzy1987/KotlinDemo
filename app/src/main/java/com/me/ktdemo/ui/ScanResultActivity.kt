package com.me.ktdemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.me.ktdemo.R
import kotlinx.android.synthetic.main.activity_scan_result.*



class ScanResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_result)

        initView()
    }

    private fun initView() {
        backLl.setOnClickListener { finish() }
        tv.text = intent.getStringExtra("content")


    }


}
