package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class EmployeeItemInfo : AppCompatActivity() {
   // lateinit var pushing
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_item_info)
        readItemFromDatabase()

    }

    private fun readItemFromDatabase()
    {
        val myRef = MainActivity.database.reference.child("store").child("ProductData").child("NewItem" + intent.getStringExtra("ITEM_ID"))
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                findViewById<EditText>(R.id.iNameInfo).setText(dataSnapshot.child(getString(R.string.path_name)).value.toString())
                findViewById<EditText>(R.id.editExpire).setText(dataSnapshot.child(getString(R.string.path_exp_date)).value.toString())
                findViewById<EditText>(R.id.iSizeInfo).setText(dataSnapshot.child(getString(R.string.path_size)).value.toString())
                findViewById<EditText>(R.id.iBarInfo).setText(dataSnapshot.child(getString(R.string.path_barcode)).value.toString())
                findViewById<EditText>(R.id.editDetail).setText(dataSnapshot.child(getString(R.string.path_details)).value.toString())
                findViewById<EditText>(R.id.iQtyInfo).setText(dataSnapshot.child(getString(R.string.path_qty)).value.toString())
                println(dataSnapshot.child("Name").value)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("Database read Error", error.message )
            }
        })
    }

    fun onCancelClick(view: View) {
        val intent = Intent(this, EmployeeHome::class.java)
        startActivity(intent)
        finish()
    }
    fun onEditItemClick(view: View) {
        val intent = Intent(this, EmployeeEditItem::class.java)
        //intent.putExtra ( "ITEM_edit",  intent.getStringExtra("ITEM_ID"));
        startActivity(intent)
    }

}