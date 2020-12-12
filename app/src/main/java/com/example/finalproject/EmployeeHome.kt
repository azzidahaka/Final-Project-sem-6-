package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EmployeeHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_home)
    }

    fun onScanClick(view: View) {
        val intent = Intent(this, CameraOpen::class.java)
        startActivity(intent)
        finish()
    }
    fun onAddItemClick(view: View) {
        val intent = Intent(this, EmployeeNewItem::class.java)
        startActivity(intent)
        finish()
    }
}