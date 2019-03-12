package com.me.ktdemo.ui



import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.PermissionChecker.checkSelfPermission
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.me.ktdemo.R
import com.me.ktdemo.adapter.KtListAdapter
import com.me.ktdemo.base.BaseFragment
import com.me.ktdemo.entity.VoiceFMBean
import com.me.ktdemo.network.DataLoader
import com.yanzhenjie.permission.AndPermission
import kotlinx.android.synthetic.main.fragment_index.*
import kotlinx.android.synthetic.main.include_toolbar_scan_layout.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doFromSdk
import org.jetbrains.anko.uiThread

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
//        tv.text = TextAppearanceUtil.setTextDescRed(context,"承租方信息","(必填)")
        recyclerView.layoutManager = LinearLayoutManager(context)

        initRefreshLayout()
        getVoiceList()
        startScanner()
    }

    private fun initRefreshLayout() {
        refreshLayout.setOnRefreshListener {
            getVoiceList()
        }
    }

    private fun getVoiceList() = doAsync{
        val voiceList: ArrayList<VoiceFMBean> = DataLoader().getVoiceList("offset=0&speaker_id=0&tag=%E6%8A%91%E9%83%81%E7%97%87%E6%98%AF%E6%9D%A1%E9%BB%91%E7%8B%97&rows=10&key=046b6a2a43dc6ff6e770255f57328f89")
        uiThread {
            recyclerView.adapter = KtListAdapter(voiceList,context){
//                val it = it as VoiceFMBean
//                val intent = Intent(Intent.ACTION_SEND).setType("image/jepg")
//                intent.putExtra(Intent.EXTRA_STREAM,Uri.parse(activity!!.re))
//                startActivity(Intent.createChooser(intent,"图片"))
            }
            if (refreshLayout.isRefreshing) refreshLayout.isRefreshing = false
        }
    }

    private fun startScanner() {
//        0 => hasPermission -1 =>deny
        scanIv.setOnClickListener {
            doFromSdk(Build.VERSION_CODES.M) {
                println("version ${Build.VERSION.SDK_INT}")
                println("check permission ${checkSelfPermission(this.context!!, Manifest.permission.CAMERA)}")
                if (checkSelfPermission(this.context!!, Manifest.permission.CAMERA) ==-1){
                    AndPermission.with(this)
                            .runtime()
                            .permission(Manifest.permission.CAMERA)
                            .onDenied { showToast("has deny the permission grant") }
                            .onGranted { startActivity(Intent(context, QRCodeScannerActivity::class.java)) }
                            .start()

                }else startActivity(Intent(context, QRCodeScannerActivity::class.java))
                return@setOnClickListener
            }
            startActivity(Intent(context, QRCodeScannerActivity::class.java))
        }
    }


}
