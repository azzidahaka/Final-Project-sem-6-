package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class CustomerProductDetailedInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_product_detailed_info)
        readItemFromDatabase()
    }

    fun onBackProductClick(view: View) {
        //call camera activity
        val intent = Intent(this, CustomerProductInfo::class.java)
        startActivity(intent)
        finish()
    }

    private fun readItemFromDatabase()
    {
        val myRef = MainActivity.database.reference.child("store").child("ProductData").child("NewItem" + intent.getStringExtra("CUSTOMER_DETAIL_ID"))
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                findViewById<TextView>(R.id.textViewDetail).text = dataSnapshot.child(getString(R.string.path_details)).value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("Database read Error", error.message )
            }
        })
    }

    fun onBackScannerClick(view: View) {
        //call camera activity
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }
}