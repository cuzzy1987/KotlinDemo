package com.me.ktdemo.ui



import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.me.ktdemo.QRCode.QRCodeScannerActivity
import com.me.ktdemo.R
import com.me.ktdemo.base.BaseFragment
import com.me.ktdemo.util.TextAppearanceUtil
import kotlinx.android.synthetic.main.fragment_index.*
import kotlinx.android.synthetic.main.include_toolbar_scan_layout.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class IndexFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_index, container, false)
    }


    override fun initView() {
        tv.text = TextAppearanceUtil.setTextDescRed(context,"承租方信息","(必填)")
        scanIv.setOnClickListener { startActivity(Intent(context,QRCodeScannerActivity::class.java)) }
    }


    /*override fun onClick(v: View?) {
        when(v){
            tv -> {showToast("okay")}
            scanIv -> startActivity(Intent(
                    context, QRCodeScannerActivity::class.java
            ))
        }
    }*/


}
