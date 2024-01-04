package com.example.practica_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica_2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding
    private var  contador : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySecondBinding.inflate(layoutInflater)
        //textoContador es un componente de la interfaz de usuario (TextView) que muestra el valor actual del contador

        setContentView(binding.root)

        //recuperamos los datos mediante la etiqueta

         contador = intent.extras?.getInt("Contador") ?:-1
        binding.textoContador.text = contador.toString()
    }
}