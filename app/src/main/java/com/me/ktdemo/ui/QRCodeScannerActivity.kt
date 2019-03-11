package com.me.ktdemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class QRCodeScannerActivity : AppCompatActivity() ,ZXingScannerView.ResultHandler{

    lateinit var mZXingScannerView: ZXingScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mZXingScannerView = ZXingScannerView(this)
        setContentView(mZXingScannerView)
    }

    /* raw -> 生肉 */
    override fun handleResult(rawResult: Result?) {
        toast(rawResult.toString())
        mZXingScannerView.resumeCameraPreview(this)
        finish()
        startActivity<ScanResultActivity>("content" to rawResult.toString() )
    }


    override fun onResume() {
        super.onResume()
        mZXingScannerView.setResultHandler(this)
        mZXingScannerView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        mZXingScannerView.stopCamera()
    }

}
