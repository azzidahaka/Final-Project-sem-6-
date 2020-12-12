package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class EmployeeItemInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_item_info)
    }

    fun onCancelClick(view: View) {
        val intent = Intent(this, EmployeeHome::class.java)
        startActivity(intent)
        finish()
    }
    fun onEditItemClick(view: View) {
        val intent = Intent(this, EmployeeEditItem::class.java)
        startActivity(intent)
    }

}