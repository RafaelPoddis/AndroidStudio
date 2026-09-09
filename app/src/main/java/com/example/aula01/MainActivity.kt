package com.example.aula01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn)

        startBtn.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

    }
}