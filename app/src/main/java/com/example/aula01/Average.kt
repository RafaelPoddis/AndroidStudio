package com.example.aula01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class Average : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_average)

        val nota1 = findViewById<EditText>(R.id.nota1)
        val nota2 = findViewById<EditText>(R.id.nota2)
        val nota3 = findViewById<EditText>(R.id.nota3)
        val calculateBtn = findViewById<Button>(R.id.calcular)
        val resultado = findViewById<TextView>(R.id.resultado)

        calculateBtn.setOnClickListener {
            val nota1 = nota1.text.toString().toDoubleOrNull()
            val nota2 = nota2.text.toString().toDoubleOrNull()
            val nota3 = nota3.text.toString().toDoubleOrNull()
            if (nota1 == null || nota2 == null || nota3 == null){
                resultado.text = "Nota inválida!"
                return@setOnClickListener
            }
            val media = (nota1+nota2+nota3)/3
            resultado.text = "A média é $media"
        }
    }
}

