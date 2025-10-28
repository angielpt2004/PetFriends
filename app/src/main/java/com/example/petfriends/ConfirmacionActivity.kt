package com.example.petfriends

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * Pantalla de confirmación
 * - Muestra los datos recibidos y mensaje personalizado.
 * - Botón para volver al inicio (MainActivity).
 */
class ConfirmacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        val tvDatos = findViewById<TextView>(R.id.tvDatos)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        val imgHappy = findViewById<ImageView>(R.id.imgHappy)
        val btnVolver = findViewById<Button>(R.id.btnVolverInicio)

        // Obtener extras del Intent
        val nombre = intent.getStringExtra("EXTRA_NOMBRE") ?: "amigo/a"
        val correo = intent.getStringExtra("EXTRA_CORREO") ?: "tu correo"
        val tipo = intent.getStringExtra("EXTRA_TIPO") ?: "una mascota"

        // Mostrar datos
        val datos = "Nombre: $nombre\nCorreo: $correo\nTipo: $tipo"
        tvDatos.text = datos

        // Mensaje personalizado
        tvMensaje.text = "¡Gracias $nombre por adoptar con PetFriends! Pronto te contactaremos al correo $correo."

        // Imagen (asegúrate de tener ic_pet_happy en drawable)
        // imgHappy.setImageResource(R.drawable.ic_pet_happy)

        // Volver al inicio: limpiar stack y volver a MainActivity
        btnVolver.setOnClickListener {
            val intent = Intent(this@ConfirmacionActivity, MainActivity::class.java)
            // Opcional: limpiar actividades para evitar volver aquí con back
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
