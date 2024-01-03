package com.example.practica_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
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
    private  var botonPasar : Button? = null
    private var  contador : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        /*el savedInstanceState es donde se guarda el 'Estado de la Instancia Guardado'
        Se utiliza para enviar los datos de la aplicacion al layout horizontal
        bundle tiene '?' porque puede ser nulo. Por ejemplo al ejecutar la aplicacion de 0
        puede estar vacía sin datos que guardar, osea, nulo. */

        super.onCreate(savedInstanceState)

        Log.v ("ciclo", "ejecutando onCreate")

        //si se rompe la aplicacion, hay que recuperar los datos:
       contador = savedInstanceState?.getInt("contador")  ?:0
        /*da error, y se añade el '?' y un valor por defecto -> ?:=
        de esta forma si savedInstanceState es nulo salta el get int al ?:0. A esto se le llama operacion condicional,
        pero no es lo mismo que un if ternario.*/
        //una ve recuperado el estado:


        // asociar la parte logica a la parte grafica
        setContentView(R.layout.activity_main)

        //incializamos los elementos
        botonDecremento = findViewById(R.id.boton_decremento)
        botonIncremento = findViewById(R.id.boton_incremento)
        textoContador = findViewById(R.id.texto_contador)
        botonPasar = findViewById(R.id.boton_pasar)
        textoContador.text = contador.toString(); // porque no pueden ponerse nmeros en un texto(?)

        // decir a los botones que tienen que escuchar algo
        botonIncremento.setOnClickListener(this) // this -> polimorfismo
        botonDecremento.setOnClickListener(this)
        botonPasar?.setOnClickListener(this)

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

                R.id.boton_pasar ->{

                }

        }
            textoContador.text = contador.toString()

    }

    override fun onSaveInstanceState(outState: Bundle) { //este bundle no es nulo porque siempre tiene que guadar algo
        super.onSaveInstanceState(outState)

        //para clave-valor
        outState.putInt("Contador", contador)

        }
    }


