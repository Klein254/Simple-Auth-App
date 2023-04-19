package com.example.authregobiero

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edtFirstName:EditText
    lateinit var edtSecondName:EditText
    lateinit var edtEmail:EditText
    lateinit var edtPassword:EditText
    lateinit var btnRegister:Button
    lateinit var btnLogin:Button
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtFirstName = findViewById(R.id.edtFirstName)
        edtSecondName = findViewById(R.id.edtSecondName)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnRegister = findViewById(R.id.btnRegister)
        btnLogin = findViewById(R.id.btnLogin)

        db = openOrCreateDatabase("ObieroDB", Context.MODE_PRIVATE, null)

        db.execSQL("CREATE TABLE IF NOT EXISTS users(FirstName VARCHAR, SecondName VARCHAR, Email VARCHAR, Password VARCHAR)")

        btnRegister.setOnClickListener {

            var FirstName_edt = edtFirstName.text.toString().trim()
            var SecondName_edt = edtSecondName.text.toString().trim()
            var Email_edt = edtEmail.text.toString().trim()
            var Password_edt = edtPassword.text.toString().trim()


            if (FirstName_edt.isEmpty() || SecondName_edt.isEmpty() || Email_edt.isEmpty() || Password_edt.isEmpty()){
                Toast.makeText(this, "Cannot Submit an Empty Field", Toast.LENGTH_SHORT).show()
            }
            else{
                db.execSQL("INSERT INTO users VALUES('\"+FirstName_edt+\"', '\"+SecondName_edt+\"', '\"+Email_edt+\"', '\"+Password_edt+\"')")

                Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()

                val open_LOGIN = Intent(this, LoginActivity::class.java)
                startActivity(open_LOGIN)
            }
        }

        btnLogin.setOnClickListener {
            val open_LOGIN = Intent(this, LoginActivity::class.java)
            startActivity(open_LOGIN)
        }
    }
}