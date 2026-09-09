package com.example.aula01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class IMC : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_imc)

        val menuBtn = findViewById<ImageButton>(R.id.menuBtn)

        menuBtn.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

        val altura = findViewById<EditText>(R.id.alturaValue).text.toString().toDoubleOrNull()
        val peso = findViewById<EditText>(R.id.pesoValue).text.toString().toDoubleOrNull()
        val resultLabel = findViewById<TextView>(R.id.resultadoImc)

        val calculateBtn = findViewById<Button>(R.id.calculateImc)

        calculateBtn.setOnClickListener {
            if (altura == null || peso == null){
                resultLabel.text = getText(R.string.invalidValue)
                return@setOnClickListener
            }
            val imc = calculateIMC(altura=altura, peso=peso)
            when {
                imc < 18.5 -> resultLabel.text = "Seu IMC é de $imc - Abaixo do peso"
                imc < 25.0 -> resultLabel.text = "Seu IMC é de $imc - Peso normal"
                imc < 30.0 -> resultLabel.text = "Seu IMC é de $imc - Sobrepeso"
                imc < 35.0 -> resultLabel.text = "Seu IMC é de $imc - Obesidade grau I"
                imc < 40.0 -> resultLabel.text = "Seu IMC é de $imc - Obesidade grau II"
                else -> resultLabel.text = "Seu IMC é de $imc - Obesidade grau III"
            }
        }
    }

    private fun calculateIMC(altura: Double, peso: Double) : Double {
        val treatedAltura = altura / 100

        return peso / (treatedAltura*treatedAltura)
    }
}