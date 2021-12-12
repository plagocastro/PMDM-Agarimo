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


        mLogin.setOnClickListener() {
            login()
        }

    }

    private fun login() {
        var email: String = mEmail.getText().toString()
        var password: String = mPassword.getText().toString()

        if (!email.isEmpty() && !password.isEmpty()) {
            if (password.length >= 6) {

            }
        }
    }
}

