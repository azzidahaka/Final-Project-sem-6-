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
import org.w3c.dom.Text

class EmployeeEditItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_edit_item)

        getAllData();
    }

    lateinit var myCode:Text//will be used to get scanner item

    fun onCancelClick(view: View) {
        val intent = Intent(this, EmployeeItemInfo::class.java)
        startActivity(intent)
        finish()
    }

    fun onUpdateItemClick(view: View) {


    }

    private fun getAllData()
    {
        println("AAAAAAAAAAAAAAFFFTTTTTTTTTEEERRRRRRRRRRRR!!!!" +  intent.getStringExtra("ITEM_ID"));
        val myRef = MainActivity.database.reference.child("store").child("ProductData").child("NewItem" + intent.getStringExtra("ITEM_ID"))
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
                println(dataSnapshot.child("Name").value)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("Database read Error", error.message )
            }
        })
    }
    private fun basicWrite() {
        var allGood = true
        val itemName = findViewById<EditText>(R.id.editNameblBL)
        val itemSize = findViewById<EditText>(R.id.editExpire)
        val itemExpDate = findViewById<EditText>(R.id.editSize)
        val itemBarCode = findViewById<EditText>(R.id.editBarcode)
        val itemDetails = findViewById<EditText>(R.id.editDetail)
        val itemQty = findViewById<EditText>(R.id.editQty)

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
            AlertDialog.Builder(this)
                .setTitle("Saved!")
                .setPositiveButton(android.R.string.ok, null)
                .show()
            val intent = Intent(this, EmployeeHome::class.java)
            startActivity(intent)
            finish()
        }
    }







































//    private fun updateItem(itemName: String, itemSize: String, itemExpDate: String, itemBarCode: String, itemDetails: String, itemQty: String) {
//        // Create new post at /user-posts/$userid/$postid and at
//        // /posts/$postid simultaneously
//        val key = MainActivity.database.reference.child("store").child("ProductData").child("NewItem" + itemBarCodeEdit.text).push().key
//        if (key == null) {
//            Log.w("Problems", "Couldn't get push key for posts")
//            return
//        }
//
//        val post = Post(userId, username, title, body)
//        val postValues = post.toMap()
//
//        val childUpdates = hashMapOf<String, Any>(
//            "/posts/$key" to postValues,
//            "/user-posts/$userId/$key" to postValues
//        )
//
//        MainActivity.database.updateChildren(childUpdates)
//        MainActivity.database.child("users").child(userId).setValue(user)
//            .addOnSuccessListener {
//                // Write was successful!
//                // ...
//            }
//            .addOnFailureListener {
//                // Write failed
//                // ...
//            }
//    }
}