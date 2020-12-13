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

class CustomerProductInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_product_info)
        readItemFromDatabase()
    }

    fun onBackClick(view: View) {
        //call camera activity
        val intent = Intent(this, CustomerHome::class.java)
        startActivity(intent)
        finish()
    }

    private fun readItemFromDatabase()
    {
        val myRef = MainActivity.database.reference.child("store").child("ProductData").child("NewItem" + intent.getStringExtra("CUSTOMER_ITEM_ID"))
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                findViewById<TextView>(R.id.textViewProductName).text = dataSnapshot.child(getString(R.string.path_name)).value.toString()
                findViewById<TextView>(R.id.textView1ProductExpireEdit).text = dataSnapshot.child(getString(R.string.path_exp_date)).value.toString()
                findViewById<TextView>(R.id.textViewProductSizeEdit).text = dataSnapshot.child(getString(R.string.path_size)).value.toString()
                findViewById<TextView>(R.id.textViewProductPriceEdit).text = dataSnapshot.child(getString(R.string.path_price)).value.toString()
                findViewById<TextView>(R.id.textViewProductQtyEdit).text = dataSnapshot.child(getString(R.string.path_qty)).value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("Database read Error", error.message )
            }
        })
    }

    fun onDetailedInfoClick(view: View) {
        //call detail info activity
        val intentNext = Intent(this, CustomerProductDetailedInfo::class.java)
        intentNext.putExtra ( "CUSTOMER_DETAIL_ID", intent.getStringExtra("CUSTOMER_ITEM_ID") );
        startActivity(intentNext)
    }
}