package com.dam2.pmdm_agarimo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mPaciente: Button = findViewById(R.id.bPaciente)
        val mProfesional: Button = findViewById(R.id.bProfesional)

        mPaciente.setOnClickListener() {
            MenuSesion()
        }
        mProfesional.setOnClickListener() {
            MenuSesion()
        }

    }

    private fun MenuSesion() {
        val intent = Intent(this, MenuEleccion::class.java)
        startActivity(intent)
    }
}
