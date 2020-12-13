package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator


class CustomerHome : AppCompatActivity() {

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

    fun onScannerClick(view: View) {
        val intentIntegrator = IntentIntegrator(this@CustomerHome)
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
                val intent = Intent(this, CustomerProductInfo::class.java)
                intent.putExtra ( "CUSTOMER_ITEM_ID", result.contents );
                startActivity(intent)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun onCustomerInfoClick(view: View) {
        val intent = Intent(this, CustomerInfo::class.java)
        startActivity(intent)
    }
}