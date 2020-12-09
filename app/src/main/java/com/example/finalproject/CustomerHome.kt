package com.example.finalproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class CustomerHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_home)
    }
//
//    lateinit var mCamera: Camera
//
//    var options = BarcodeScannerOptions.Builder()
//            .setBarcodeFormats(
//                    Barcode.FORMAT_EAN_13,
//                    Barcode.FORMAT_EAN_8,
//                    Barcode.FORMAT_CODE_93
//            ).build()
//

    fun onScannerClick(view: View) {
        //call another activity
    }
}