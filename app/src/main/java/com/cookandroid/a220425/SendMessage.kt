package com.cookandroid.a220425

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class SendMessage :  AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_sms);
        ActivityCompat.requestPermissions(
            this@SendMessage,
            arrayOf(Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS),
            PackageManager.PERMISSION_GRANTED
        )
        var sendSMSBt = findViewById<Button>(R.id.send_sms_button)
        var inputPhoneNum = findViewById<EditText>(R.id.input_phone_num)


        sendSMSBt.setOnClickListener{
            sendSMS(inputPhoneNum.getText().toString(), "안녕")
        }
    }
    open fun sendSMS(phoneNumber: String?, message: String?) {
        val mysmsManager = SmsManager.getDefault()
        mysmsManager.sendTextMessage(phoneNumber, null, message, null, null)
    }
}
