package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CustomerProductDetailedInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_product_detailed_info)
    }

    fun onBackProductClick(view: View) {
        //call camera activity
        val intent = Intent(this, CustomerProductInfo::class.java)
        startActivity(intent)
    }
    fun onBackScannerClick(view: View) {
        //call camera activity
        val intent = Intent(this, CameraOpen::class.java)
        startActivity(intent)
    }
}