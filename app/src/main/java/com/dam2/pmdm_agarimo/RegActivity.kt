package com.dam2.pmdm_agarimo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        val brRegistrar: Button = findViewById(R.id.bRegister2)
        val brNombre: EditText = findViewById(R.id.name)
        val brEmail: EditText = findViewById(R.id.emailAccess4)
        val brContraseña: EditText = findViewById(R.id.passwordAccess)

        val autentificacion: FirebaseAuth = FirebaseAuth.getInstance()

        fun mapaIr() {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        fun registrarUsuario() {
            var name: String = brNombre.getText().toString()
            var email: String = brEmail.getText().toString()
            var password: String = brContraseña.getText().toString()

            if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                if (password.length >= 6) {
                    autentificacion.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful()) {
                                Toast.makeText(this,"Registro completado correctamente",Toast.LENGTH_SHORT).show()
                                mapaIr()
                            } else {
                                Toast.makeText(this,"No se pudo registrar el usuario",Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(this,"Por favor 6 caracteres mínimo",Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"Te faltan datos, completalos",Toast.LENGTH_SHORT).show()
            }
        }

        brRegistrar.setOnClickListener() {
            registrarUsuario()
        }
    }

}