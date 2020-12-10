package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class CustomerInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_info)

    }

    fun onBackMainClick(view: View) {
        //call camera activity
        val intent = Intent(this, CustomerHome::class.java)
        intent.putExtra ( "USER_NAME", findViewById<EditText>(R.id.editTextUserName).text.toString() );
        startActivity(intent)
    }
}