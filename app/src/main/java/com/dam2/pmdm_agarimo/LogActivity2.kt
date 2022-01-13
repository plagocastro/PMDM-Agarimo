package com.dam2.pmdm_agarimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LogActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log2)

        val mEmail: EditText = findViewById(R.id.emailAccess)
        val mPassword: EditText = findViewById(R.id.passwordAccess)
        val rLogin: Button = findViewById(R.id.bLogin)

        fun login() {
            var email: String = mEmail.getText().toString()
            var password: String = mPassword.getText().toString()

            if (!email.isEmpty() && !password.isEmpty()) {
                if (password.length >= 6) {
                } else {
                    Toast.makeText(this, "Email o Contraseña incorrectos", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        rLogin.setOnClickListener() {
            login()
        }
    }
}

