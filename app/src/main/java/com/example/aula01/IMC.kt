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

        val alturaView = findViewById<EditText>(R.id.alturaValue)
        val pesoView = findViewById<EditText>(R.id.pesoValue)
        val resultLabel = findViewById<TextView>(R.id.resultadoImc)

        val calculateBtn = findViewById<Button>(R.id.calculateImc)

        calculateBtn.setOnClickListener {
            val altura = alturaView.text.toString().toDoubleOrNull()
            val peso = pesoView.text.toString().toDoubleOrNull()
            if (altura == null || peso == null){
                resultLabel.text = getText(R.string.invalidValue)
                return@setOnClickListener
            }
            val imc = calculateIMC(altura=altura, peso=peso)
            when {
                imc < 18.5 -> resultLabel.text = "Seu IMC é de %.2f - Abaixo do peso".format(imc)
                imc < 25.0 -> resultLabel.text = "Seu IMC é de %.2f - Peso normal".format(imc)
                imc < 30.0 -> resultLabel.text = "Seu IMC é de %.2f - Sobrepeso".format(imc)
                imc < 35.0 -> resultLabel.text = "Seu IMC é de %.2f - Obesidade grau I".format(imc)
                imc < 40.0 -> resultLabel.text = "Seu IMC é de %.2f - Obesidade grau II".format(imc)
                else -> resultLabel.text = "Seu IMC é de %.2f - Obesidade grau III".format(imc)
            }
        }
    }

    private fun calculateIMC(altura: Double, peso: Double) : Double {
        val treatedAltura = altura / 100

        return peso / (treatedAltura*treatedAltura)
    }
}