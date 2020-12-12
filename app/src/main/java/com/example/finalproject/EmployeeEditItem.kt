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
        var updateRef = MainActivity.database.reference.child("store").child("ProductData").child("NewItem" + myCode.textContent)

        updateRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                findViewById<EditText>(R.id.editTextItemNameInfoEdit).setText(dataSnapshot.child("NewItem" + myCode.textContent).value.toString())
                findViewById<EditText>(R.id.editTextSizeInfoEdit).setText(dataSnapshot.child(getString(R.string.path_size)).value.toString())
                findViewById<EditText>(R.id.editTextExpireDateInfoEdit).setText(dataSnapshot.child(getString(R.string.path_exp_date)).value.toString())
                findViewById<EditText>(R.id.editTextBarcodeInfoEdit).setText(dataSnapshot.child(getString(R.string.path_barcode)).value.toString())
                findViewById<EditText>(R.id.editTextDetailInfoInfoEdit).setText(dataSnapshot.child(getString(R.string.path_details)).value.toString())
                findViewById<EditText>(R.id.editTextQtyInfoEdit).setText(dataSnapshot.child(getString(R.string.path_qty)).value.toString())

                val itemNameEdit = findViewById<EditText>(R.id.editTextItemNameInfoEdit)
                val itemSizeEdit  = findViewById<EditText>(R.id.editTextSizeInfoEdit)
                val itemExpDateEdit  = findViewById<EditText>(R.id.editTextExpireDateInfoEdit)
                val itemBarCodeEdit  = findViewById<EditText>(R.id.editTextBarcodeInfoEdit)
                val itemDetailsEdit  = findViewById<EditText>(R.id.editTextDetailInfoInfoEdit)
                val itemQtyEdit  = findViewById<EditText>(R.id.editTextQtyInfoEdit)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("Database read Error", error.message )
            }
        })
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