package com.example.practica_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.practica_2.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), OnClickListener {
// Implementamos la interfaz OnClick, que nos permite implementar el metodo OnClick

    //delcaramos las variables que relacionaremos con los botones
       private var  contador : Int = 0

    private lateinit var binding : ActivityMainBinding  //guarda el contenido de la parte grafica

    override fun onCreate(savedInstanceState: Bundle?) {
        /*el savedInstanceState es donde se guarda el 'Estado de la Instancia Guardado'
        Se utiliza para enviar los datos de la aplicacion al layout horizontal
        bundle tiene '?' porque puede ser nulo. Por ejemplo al ejecutar la aplicacion de 0
        puede estar vacía sin datos que guardar, osea, nulo. */

        super.onCreate(savedInstanceState)

        //inicializamos binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        /* inflate porque lo queremos rellenar con laout inflater, que lo que hacer es rellenar
        / la parte del layut con, en este caso, ActivityMainBinding*/


        // asociar la parte logica a la pat.activrte grafica
                setContentView(binding.root) /* pone como vista lo que hay en el fichero,
        en concreto lo que hay en la parte principal, el XML.*/


        //si se rompe la aplicacion, hay que recuperar los datos:
       contador = savedInstanceState?.getInt("Contador")  ?:0
        /*da error, y se añade el '?' y un valor por defecto -> ?:=
        de esta forma si savedInstanceState es nulo salta el get int al ?:0. A esto se le llama operacion condicional,
        pero no es lo mismo que un if ternario.*/
        //una ve recuperado el estado:




        //incializamos los elementos


           binding.textoContador.text = contador.toString(); // porque no pueden ponerse nmeros en un texto(?)

        // decir a los botones que tienen que escuchar algo
        binding.botonIncremento.setOnClickListener(this) // this -> polimorfismo
        binding.botonDecremento.setOnClickListener(this)
        binding.botonPasar?.setOnClickListener(this)
        binding.botonPasar2?.setOnClickListener(this)
    }

    override fun onClick(v: View?) { //se crea automaticamente al implementar OnClickListener
        //diferenciar quien ha pulsado
        //peguntamos al parametro que nos da por defecto, 'v', a que variabe se refiere, botonIncremento o Decremento
        when (v?.id) {//hay que ponr '?' porque la variable View puede ser nula
            binding.botonIncremento.id -> {
                //creo arriba la variable contador
                contador++
            }

            binding.botonDecremento.id -> {
                contador--
            }

                binding.botonPasar?.id ->{
                    val intent = Intent(applicationContext, SecondActivity::class.java) //para insertar acciones
                    //desde this o AppplicationContext hasta econdActivity, la segunda pantalla y el tipo de archivo que es
                    intent.putExtra("Contador", contador) //etiqueta y variable que pasamos
                    startActivity(intent) // arrancar la accion
                    //al intent le ponemos un bandle en el que metemos a cosas que queremos que viajen de una pantalla a otra

                }
            binding.botonPasar2?.id ->{
                val intent = Intent(applicationContext, SecondActivity::class.java) //para insertar acciones
                //desde this o AppplicationContext hasta econdActivity, la segunda pantalla y el tipo de archivo que es
                startActivity(intent) // arrancar la accion

            }

        }
        binding.textoContador.text = contador.toString()
        //textoContador es un componente de la interfaz de usuario (TextView) que muestra el valor actual del contador

    }


    override fun onSaveInstanceState(outState: Bundle) { //este bundle no es nulo porque siempre tiene que guadar algo
        super.onSaveInstanceState(outState)

        //para clave-valor
        outState.putInt("Contador", contador)

        }
    }


