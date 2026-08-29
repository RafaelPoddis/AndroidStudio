package com.example.aula01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aula01.ui.theme.Aula01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /*setContent {
            Aula01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }*/
        setContentView(R.layout.layout)

        val nota1 = findViewById<EditText>(R.id.nota1)
        val nota2 = findViewById<EditText>(R.id.nota2)
        val nota3 = findViewById<EditText>(R.id.nota3)
        val botao = findViewById<Button>(R.id.calcular)
        val resultado = findViewById<TextView>(R.id.resultado)

        botao.setOnClickListener {
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Aula01Theme {
        Greeting("Android")
    }
}