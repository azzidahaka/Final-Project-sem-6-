package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    //our path to the actual database
    companion object {
        var database = Firebase.database
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCustomerClick(view: View) {
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }

    fun onEmployeeClick(view: View) {
        val intent = Intent(this, EmployeeHome::class.java)
        startActivity(intent)
        finish()
    }
}