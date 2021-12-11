package com.dam2.pmdm_agarimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LogActivity2 : AppCompatActivity() {
    val mEmail: EditText = findViewById(R.id.emailAccess)
    val mPassword: EditText = findViewById(R.id.passwordAccess)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log2)

        val mLogin: Button = findViewById(R.id.bLogin)
        val mRegister: Button = findViewById(R.id.bRegister)

        mLogin.setOnClickListener() {
            login()
        }

    }

    private fun login() {
        var email: String = mEmail.getText().toString()
        var password: String = mPassword.getText().toString()

        if (!email.isEmpty() && !password.isEmpty()) {
            // Validación para ver si la contraseña en mayor o igual a 6
            if (password.length >= 6) {

            }
        }
    }
}

