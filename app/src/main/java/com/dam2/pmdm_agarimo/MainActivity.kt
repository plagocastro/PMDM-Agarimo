package com.dam2.pmdm_agarimo


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.activity_main))


        val mLogin: Button = findViewById(R.id.bLogin)
        val mRegister: Button = findViewById(R.id.bRegister)

        mLogin.setOnClickListener() {
            Loguearse()
        }
        mRegister.setOnClickListener() {
            Registrarse()
        }

    }

    private fun Registrarse() {
        val intent = Intent(this, RegActivity::class.java)
        startActivity(intent)
    }
    private fun Loguearse() {
        val intent2 = Intent(this, LogActivity2::class.java)
        startActivity(intent2)
    }
}
