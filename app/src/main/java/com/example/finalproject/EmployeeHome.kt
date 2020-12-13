package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

class EmployeeHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_home)
    }

    fun onScanClick(view: View) {
        val intentIntegrator = IntentIntegrator(this@EmployeeHome)
        intentIntegrator.setBeepEnabled(false)
        intentIntegrator.setCameraId(0)
        intentIntegrator.setPrompt("SCAN")
        intentIntegrator.setBarcodeImageEnabled(false)
        intentIntegrator.initiateScan()
    }

    override fun onActivityResult(
            requestCode: Int,
            resultCode: Int,
            data: Intent?
    ) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents === null) {
                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show()
            } else {
//                Toast.makeText(this, "Scanned -> " + result.contents, Toast.LENGTH_SHORT)
//                        .show()
                //itemIdEmployee.text = result.contents
                intent.putExtra ( "ITEM_ID", result.contents );
                val intent = Intent(this, EmployeeItemInfo::class.java)
                startActivity(intent)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun onAddItemClick(view: View) {
        val intent = Intent(this, EmployeeNewItem::class.java)
        startActivity(intent)
        finish()
    }
}