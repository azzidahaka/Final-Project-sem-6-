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

class EmployeeEditItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_edit_item)

        //call to get all data for the current item
        getAllData();
    }

    fun onCancelClick(view: View) {
        val intent = Intent(this, EmployeeItemInfo::class.java)
        startActivity(intent)
        finish()
    }

    //submit our updates
    fun onUpdateItemClick(view: View) {
        saveUpdates()
    }

    //getting data and storing it into views
    private fun getAllData() {
        val myRef = MainActivity.database.reference.child("store").child("ProductData")
            .child("NewItem" + intent.getStringExtra("ITEM_EDIT"))
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                findViewById<EditText>(R.id.editNameblBL).setText(dataSnapshot.child(getString(R.string.path_name)).value.toString())
                findViewById<EditText>(R.id.editExpire).setText(dataSnapshot.child(getString(R.string.path_exp_date)).value.toString())
                findViewById<EditText>(R.id.editSize).setText(dataSnapshot.child(getString(R.string.path_size)).value.toString())
                findViewById<EditText>(R.id.editBarcode).setText(dataSnapshot.child(getString(R.string.path_barcode)).value.toString())
                findViewById<EditText>(R.id.editDetail).setText(dataSnapshot.child(getString(R.string.path_details)).value.toString())
                findViewById<EditText>(R.id.editQty).setText(dataSnapshot.child(getString(R.string.path_qty)).value.toString())
                findViewById<EditText>(R.id.editPrice).setText(dataSnapshot.child(getString(R.string.path_price)).value.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("Database read Error", error.message)
            }
        })
    }

    //read all properties and send data to the database
    private fun saveUpdates() {
        var allGood = true
        val itemName = findViewById<EditText>(R.id.editNameblBL)
        val itemSize = findViewById<EditText>(R.id.editExpire)
        val itemExpDate = findViewById<EditText>(R.id.editSize)
        val itemBarCode = findViewById<EditText>(R.id.editBarcode)
        val itemDetails = findViewById<EditText>(R.id.editDetail)
        val itemQty = findViewById<EditText>(R.id.editQty)
        val itemPrice = findViewById<EditText>(R.id.editPrice)

        if (itemName === null || itemName.text.isBlank()) {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Name is blank")
                .setMessage("Please, enter Name")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        } else if (itemSize === null || itemSize.text.isBlank()) {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Size is blank")
                .setMessage("Please, enter Size")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        } else if (itemExpDate === null || itemExpDate.text.isBlank()) {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Expire Date is blank")
                .setMessage("Please, enter Expire Date")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        } else if (itemBarCode === null || itemBarCode.text.isBlank()) {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item BarCode is blank")
                .setMessage("Please, enter BarCode")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        } else if (itemDetails === null || itemDetails.text.isBlank()) {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Detail Info is blank")
                .setMessage("Please, enter Item Details")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        } else if (itemQty === null || itemQty.text.isBlank()) {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Quantity is blank")
                .setMessage("Please, enter Quantity")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        } else if (itemPrice === null || itemPrice.text.isBlank()) {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Price is blank")
                .setMessage("Please, enter Price")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        } else {
            allGood = true
        }

        //if nothing left blank
        if (allGood === true) {
            val myRef = MainActivity.database.reference.child("store").child("ProductData")
                .child("NewItem" + itemBarCode.text)
            myRef.child(getString(R.string.path_name)).setValue(itemName.text.toString())
            myRef.child(getString(R.string.path_size)).setValue(itemSize.text.toString())
            myRef.child(getString(R.string.path_exp_date)).setValue(itemExpDate.text.toString())
            myRef.child(getString(R.string.path_barcode)).setValue(itemBarCode.text.toString())
            myRef.child(getString(R.string.path_details)).setValue(itemDetails.text.toString())
            myRef.child(getString(R.string.path_qty)).setValue(itemQty.text.toString())
            myRef.child(getString(R.string.path_price)).setValue(itemPrice.text.toString())
            AlertDialog.Builder(this)
                .setTitle("Saved!")
                .setPositiveButton(android.R.string.ok, null)
                .show()
            val intent = Intent(this, EmployeeHome::class.java)
            startActivity(intent)
            finish()
        }
    }
}