package com.dam2.pmdm_agarimo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LogActivity2 : AppCompatActivity() {

    private val TAG = "RealTime"
    private lateinit var database:DatabaseReference
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log2)
        database = Firebase.database.getReference("user")

        val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
        val mDatabase: DatabaseReference = FirebaseDatabase.getInstance().getReference()

        val mEmail: EditText = findViewById(R.id.emailAccess)
        val mPassword: EditText = findViewById(R.id.passwordAccess)
        val rLogin: Button = findViewById(R.id.bLogin)
        val bRealtime:Button = findViewById(R.id.realTime)

        fun writeNewData(nombre: String, lt: Double, lg: Double){
            Log.d(TAG, "Escribiendo datos")
            val user= Profesionales(nombre, lt, lg)
            database.push().setValue(user)

        }

        bRealtime.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View){
                writeNewData("ElPaco",0.22,6.5252)
            }
        })
        val miTexto: TextView = findViewById(R.id.datosRealTime)

        val datoListener = object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val dato = dataSnapshot.getValue()
                Log.d(TAG,"cambio: " + dato.toString())
                miTexto.text = dato.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG,"loadPost:onCancelled", databaseError.toException())
            }
        }
        database.addValueEventListener(datoListener)

        fun mapaIr() {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        fun login() {
            var email: String = mEmail.getText().toString()
            var password: String = mPassword.getText().toString()

            if (!email.isEmpty() && !password.isEmpty()) {
                if (password.length >= 6) {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                        if (task.isSuccessful()) {
                            val intent = Intent(this, MapsActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }else {
                    Toast.makeText(this, "Algo esta incorrecto, revisalo", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        rLogin.setOnClickListener() {
            login()
        }
    }
}

