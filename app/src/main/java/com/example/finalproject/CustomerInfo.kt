package com.example.finalproject

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class CustomerInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_info)
        readFromDatabase()
    }
    private fun readFromDatabase()
    {
        val myRef = MainActivity.database.reference.child("store").child("name")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                findViewById<EditText>(R.id.editTextPreferredStore).setText(dataSnapshot.value.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("Database read Error", error.message )
            }
        })
    }

    fun onBackMainClick(view: View) {
        //call camera activity
        val intent = Intent(this, CustomerHome::class.java)
        intent.putExtra ( "USER_NAME", findViewById<EditText>(R.id.editTextUserName).text.toString() );
        startActivity(intent)
        // don't use finish to not destroy the activity and keep data for username
    }
}