package com.example.petfriends

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Usa AppCompatActivity para compatibilidad con estilos modernos
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdoptar = findViewById<Button>(R.id.btnAdoptarNow)
        val logo = findViewById<ImageView>(R.id.imgWelcome)
        val txtBienvenida = findViewById<TextView>(R.id.txtIntro)

        // Navegar a FormularioActivity
        btnAdoptar.setOnClickListener {
            val intent = Intent(this@MainActivity, FormularioActivity::class.java)
            startActivity(intent)
        }


    }
}
