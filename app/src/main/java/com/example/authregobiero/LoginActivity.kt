package com.example.authregobiero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    lateinit var edtEmailLog:EditText
    lateinit var edtPasswordLog:EditText
    lateinit var btnLoginLog:Button
    lateinit var btnRegisterLog:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmailLog = findViewById(R.id.edtEmailLogin)
        edtPasswordLog = findViewById(R.id.edtPasswordLogin)
        btnLoginLog = findViewById(R.id.btnLoginLogin)
        btnRegisterLog = findViewById(R.id.btnRegisterLogin)

        btnLoginLog.setOnClickListener {

        }

        btnRegisterLog.setOnClickListener {
            val open_Reg = Intent(this, MainActivity::class.java)
            startActivity(open_Reg)
        }

    }
}