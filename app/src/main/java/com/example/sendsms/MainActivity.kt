package com.example.sendsms

import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS),111)
        }
        val phnnum:String=findViewById<EditText>(R.id.phnnum).toString()
        val msg:String=findViewById<EditText>(R.id.msg).toString()
        val btn: Button =findViewById(R.id.button)
        btn.setOnClickListener(){
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phnnum, null, msg, null, null)
            Toast.makeText(this,"Message Sent",Toast.LENGTH_SHORT).show()
        }
    }

}