package com.example.aula01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class Menu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_menu)

        val menuBtn = findViewById<ImageButton>(R.id.menuBtn)

        menuBtn.setOnClickListener {
            finish()
        }

        val mediaBtn = findViewById<Button>(R.id.mediaBtn)

        mediaBtn.setOnClickListener {
            startActivity(Intent(this, Average::class.java))
        }

        val imcBtn = findViewById<Button>(R.id.imcBtn)

        imcBtn.setOnClickListener {
            startActivity(Intent(this, IMC::class.java))
        }

    }
}