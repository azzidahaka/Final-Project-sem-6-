package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CustomerHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_home)

        val userName = intent.getStringExtra("USER_NAME")
        if(userName === null || userName.isBlank())
        {
            findViewById<TextView>(R.id.textViewUserActualName).text = getString(R.string.hello) + "  " + getString(
                R.string.default_name
            );
        }
        else
        {
            findViewById<TextView>(R.id.textViewUserActualName).text = getString(R.string.hello) + "  " + userName;
        }
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
        //call camera activity
        val intent = Intent(this, CameraOpen::class.java)
        startActivity(intent)
        finish()
    }

    fun onCustomerInfoClick(view: View) {
        val intent = Intent(this, CustomerInfo::class.java)
        startActivity(intent)
    }
}