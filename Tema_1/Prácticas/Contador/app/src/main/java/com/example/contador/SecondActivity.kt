package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contador.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySecondBinding
    private var contador:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //se inicializa el binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //para trasladar un dato de pantalla a pantalla
        //el intent es el que mueve el dato, y le preguntamos por los extras seañalando el tipo de dato qye estamos esperando recibr
       contador = intent.extras?.getInt("contador")?:0 //contador vale 0. El ? de extras es un null safety
        binding.textoContador.text = contador.toString()

    }
}