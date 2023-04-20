package com.example.authregobiero

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.selects.select

class LoginActivity : AppCompatActivity() {

    lateinit var edtEmailLog:EditText
    lateinit var edtPasswordLog:EditText
    lateinit var btnLoginLog:Button
    lateinit var btnRegisterLog:Button
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmailLog = findViewById(R.id.edtEmailLogin)
        edtPasswordLog = findViewById(R.id.edtPasswordLogin)
        btnLoginLog = findViewById(R.id.btnLoginLogin)
        btnRegisterLog = findViewById(R.id.btnRegisterLogin)


        btnLoginLog.setOnClickListener {
            //WRITE A LOGIC TO SEE IF USER EXISTS

            var email = edtEmailLog.text.toString().trim()
            var password = edtPasswordLog.text.toString().trim()

            // VALIDATE
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Check Your Fields", Toast.LENGTH_SHORT).show()
            }
            else{
                //LOGIC TO CHECK IF USE EXISTS


                val cursor = db.rawQuery("SELECT * FROM users WHERE Email_edt=? AND Password_edt=?", arrayOf(email, password))

                if (cursor != null && cursor.moveToFirst()) {
                    //USER IS AUTHENTICATED
                    Toast.makeText(this, "SUCCESSFULLY SIGNED IN", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password, please try again", Toast.LENGTH_SHORT).show()
                }
            }

        }

        btnRegisterLog.setOnClickListener {
            val open_Reg = Intent(this, MainActivity::class.java)
            startActivity(open_Reg)
        }

    }
}