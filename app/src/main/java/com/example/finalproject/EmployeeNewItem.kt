package com.example.finalproject

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class EmployeeNewItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_new_item)
    }

    fun onSaveItemClick(view: View) {
        basicWrite()
    }
    fun onCancelClick(view: View) {
        val intent = Intent(this, EmployeeHome::class.java)
        startActivity(intent)
        finish()
    }

    private fun basicWrite() {
        var allGood = true
        val itemName = findViewById<EditText>(R.id.editTextItemName)
        val itemSize = findViewById<EditText>(R.id.editTextSize)
        val itemExpDate = findViewById<EditText>(R.id.editTextExpireDate)
        val itemBarCode = findViewById<EditText>(R.id.editTextBarcode)
        val itemDetails = findViewById<EditText>(R.id.editTextDetailInfo)
        val itemQty = findViewById<EditText>(R.id.editTextQty)
        val itemPrice = findViewById<EditText>(R.id.editTextPrice)

        if(itemName === null || itemName.text.isBlank())
        {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Name is blank")
                .setMessage("Please, enter Name")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }
        else if(itemSize === null || itemSize.text.isBlank())
        {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Size is blank")
                .setMessage("Please, enter Size")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }
        else if(itemExpDate === null || itemExpDate.text.isBlank())
        {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Expire Date is blank")
                .setMessage("Please, enter Expire Date")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }
        else if(itemBarCode === null || itemBarCode.text.isBlank())
        {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item BarCode is blank")
                .setMessage("Please, enter BarCode")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }
        else if(itemDetails === null || itemDetails.text.isBlank())
        {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Detail Info is blank")
                .setMessage("Please, enter Item Details")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }
        else if(itemQty === null || itemQty.text.isBlank())
        {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Quantity is blank")
                .setMessage("Please, enter Quantity")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }
        else if(itemPrice === null || itemPrice.text.isBlank())
        {
            allGood = false
            AlertDialog.Builder(this)
                .setTitle("Input for Item Price is blank")
                .setMessage("Please, enter Price")
                .setPositiveButton(android.R.string.ok, null)
                .show()
        }
        else
        {
            allGood = true
        }

        if( allGood === true)
        {
            val myRef = MainActivity.database.reference.child("store").child("ProductData").child("NewItem" + itemBarCode.text)
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