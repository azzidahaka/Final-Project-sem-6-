package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CustomerProductInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_product_info)
    }

    fun onBackClick(view: View) {
        //call camera activity
        val intent = Intent(this, CameraOpen::class.java)
        startActivity(intent)
    }

    fun onDetailedInfoClick(view: View) {
        //call detail info activity
        val intent = Intent(this, CustomerProductDetailedInfo::class.java)
        startActivity(intent)
    }
}