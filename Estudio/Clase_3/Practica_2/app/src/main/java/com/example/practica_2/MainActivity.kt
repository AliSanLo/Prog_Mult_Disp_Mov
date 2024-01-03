package com.example.practica_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), OnClickListener {
// Implementamos la interfaz OnClick, que nos permite implementar el metodo OnClick

    //delcaramos las variables que relacionaremos con los botones
    private lateinit var botonIncremento: Button
    private lateinit var botonDecremento: Button
    private lateinit var textoContador: TextView
    private var  contador : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // asociar la parte logica a la parte grafica
        setContentView(R.layout.activity_main)

        //incializamos los elementos
        botonDecremento = findViewById(R.id.boton_decremento)
        botonIncremento = findViewById(R.id.boton_incremento)
        textoContador = findViewById(R.id.texto_contador)

        // decir a los botones que tienen que escuchar algo
        botonIncremento.setOnClickListener(this) // this -> polimorfismo
        botonDecremento.setOnClickListener(this)
    }

    override fun onClick(v: View?) { //se crea automaticamente al implementar OnClickListener
        //diferenciar quien ha pulsado
        //peguntamos al parametro que nos da por defecto, 'v', a que variabe se refiere, botonIncremento o Decremento
        when (v?.id) {//hay que ponr '?' porque la variable View puede ser nula
            R.id.boton_incremento -> {
                //creo arriba la variable contador
                contador++
            }

            R.id.boton_decremento -> {
                contador--
            }
        }
            textoContador.text = contador.toString()

    }
}
