package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.zxing.integration.android.IntentIntegrator

class EmployeeHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_home)
    }

    fun onScanClick(view: View) {
        val intentIntegrator = IntentIntegrator(this@EmployeeHome)
        intentIntegrator.setBeepEnabled(false)
        intentIntegrator.setCameraId(0)
        intentIntegrator.setPrompt("SCAN")
        intentIntegrator.setBarcodeImageEnabled(false)
        intentIntegrator.initiateScan()
    }
    fun onAddItemClick(view: View) {
        val intent = Intent(this, EmployeeNewItem::class.java)
        startActivity(intent)
        finish()
    }
}