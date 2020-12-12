package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class CustomerHome : AppCompatActivity() {

    companion object {
        var database = Firebase.database
        private const val TAG = "ItemInfoActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_home)

        val userName = intent.getStringExtra("USER_NAME")
        if(userName === null || userName.isBlank())
        {
            findViewById<TextView>(R.id.textViewUserActualName).text = getString(R.string.hello) + "  " + getString(
                R.string.default_name
            );
        }
        else
        {
            findViewById<TextView>(R.id.textViewUserActualName).text = getString(R.string.hello) + "  " + userName;
        }
    }
//
//    lateinit var mCamera: Camera
//
//    var options = BarcodeScannerOptions.Builder()
//            .setBarcodeFormats(
//                    Barcode.FORMAT_EAN_13,
//                    Barcode.FORMAT_EAN_8,
//                    Barcode.FORMAT_CODE_93
//            ).build()
//

    fun onScannerClick(view: View) {
        //call camera activity
        val intent = Intent(this, CameraOpen::class.java)
        startActivity(intent)
        finish()
    }

    fun onCustomerInfoClick(view: View) {
        val intent = Intent(this, CustomerInfo::class.java)
        startActivity(intent)
        readFromDatabase()
    }

    private fun readFromDatabase()
    {
        val myRef = database.reference.child("store")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value.toString()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }
}