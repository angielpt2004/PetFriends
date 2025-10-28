package com.example.petfriends

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import android.util.Patterns


class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val radioGroupTipo = findViewById<RadioGroup>(R.id.radioGroupTipo)
        val chkTerminos = findViewById<CheckBox>(R.id.chkTerminos)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val btnSalir = findViewById<Button>(R.id.btnSalir)


        btnEnviar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val correo = etCorreo.text.toString().trim()
            val seleccionadoId = radioGroupTipo.checkedRadioButtonId


            if (nombre.isEmpty()) {
                etNombre.error = "Ingresa tu nombre completo"
                etNombre.requestFocus()
                return@setOnClickListener
            }

            if (correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                etCorreo.error = "Ingresa un correo válido"
                etCorreo.requestFocus()
                return@setOnClickListener
            }

            if (seleccionadoId == -1) {
                Toast.makeText(this, "Selecciona el tipo de mascota", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!chkTerminos.isChecked) {
                Toast.makeText(this, "Debes aceptar los términos de adopción responsable", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val tipoMascota = when (seleccionadoId) {
                R.id.rbPerro -> "Perro 🐕"
                R.id.rbGato -> "Gato 🐈"
                else -> "No especificado"
            }


            val intent = Intent(this@FormularioActivity, ConfirmacionActivity::class.java).apply {
                putExtra("EXTRA_NOMBRE", nombre)
                putExtra("EXTRA_CORREO", correo)
                putExtra("EXTRA_TIPO", tipoMascota)
            }
            startActivity(intent)
        }


        btnSalir.setOnClickListener {
            
            finishAffinity()
        }
    }
}