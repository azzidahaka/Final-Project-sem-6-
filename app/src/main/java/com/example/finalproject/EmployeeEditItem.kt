package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EmployeeEditItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_edit_item)
    }

    fun onCancelClick(view: View) {
        val intent = Intent(this, EmployeeItemInfo::class.java)
        startActivity(intent)
        finish()
    }
    fun onUpdateItemClick(view: View) {}
}