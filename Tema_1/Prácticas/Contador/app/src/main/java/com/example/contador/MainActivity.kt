package com.example.contador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.contador.R
import com.example.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    //declarar variables
     /*  private lateinit var botonIncremento: Button;
         private lateinit var botonDecremento: Button;
    //la siguiente variable si la inicializabamos como lateinit, romía la aplicacion, asiq ue la inicializamos como nulo
         private var botonPasar: Button? = null;
         private lateinit var textoContador: TextView;*/
         private var contador: Int = 0; //podríamos ponerle lateinit??

    //cada parte logica tiene la siguiente variable para gusrdar el conbtwenido de la parte grafica
    private lateinit var binding : ActivityMainBinding

    //savedInstanceState: Bundle? es la instancia del estado guardado, es decir todo loq ue se haya roto en algun cambio de configuracion.
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v("ciclo", "ejecutando onCreate")
        super.onCreate(savedInstanceState)

        //al crear la variable   private lateinit var binding : ActivityMainBinding  tenemos que inicializarla aqui:
        binding = ActivityMainBinding.inflate(layoutInflater)

        //recuperamos el contador, asociandolo (guardándolo) en la variable ya creada, contador
        //da error porque si es nulo lanza un NullPointException.Podriamos corregirlo de la siguiente manera:
        //          contador = savedInstanceState?.getInt("contador")
        //Per tambien da error porque tenemos que asignar un valor por defecto.
        //Lo podriamos solucionar cinicializando contador a null: "private var contador: Int = 0;",
        // pero entonces darian error los contadores "contador++" y "contador--" del when.
        //Debemos asignarle por tanto un valor por defecto, añadiento el operador condicional "?:0"
        //Este operador nos indica que si es nullo, no hay qeu hacer caso a lo que hay detras
        // pero que si no es nulo y da 4, por ejemplo, se actualiza el valor a 4 y nos olvidamos del operador



        //La anterior linea es como el equivalente a un if-else:
        /*if (savedInstanceState == null) {
            contador= 0
        } else {
             contador = savedInstanceState?.getInt("contador")
            } */

        //este metodo adocia la parte  grafica a la parte logica
        //la siguiente linea antes era "setContentView(R.layout.activity_main)"
        setContentView(binding.root)
        contador = savedInstanceState?.getInt("contador")?:0

        //DUDA MIA: QUE ES LA R?
        /* LINEAS CREADAS ANTES DEL BINDING
        botonDecremento = findViewById(R.id.boton_decremento)
        botonIncremento = findViewById(R.id.boton_incremento)
        botonPasar = findViewById(R.id.boton_pasar)
        textoContador = findViewById(R.id.texto_contador);*/

        binding.botonDecremento
        binding.botonIncremento
        binding.botonPasar
        binding.textoContador

        //una vez recuperado el estado, se guarda en la variable del textoContador para que lo imprima por pantalla
        binding.textoContador.text = contador.toString()

        //el  metodo .setOnClickListener sirve para cuando tenemos 1 o 2 botones. Si hay mas botones hay qeu implementar
        // la interfaz con this hacemos referencia a la clase (la parte de la clase que cumple con el dato)
        binding.botonIncremento .setOnClickListener(this)
        binding.botonDecremento .setOnClickListener(this)
        binding.botonDecremento .setOnClickListener{
            // metodo onClick -> pasa un parametro tipo View  que no es nulo.
        }
        binding.botonPasar?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //Diferenciamos quién ha pulsado con el parámetro v.Le preguntamos si su id ha hecho una cosa u la otra
        //DUDA MIA: EL PARAMETRO v.view LO GENERA EL PROGRAMA O LO HA PUESTO EL PROFE? POR QUÉ view?
        //view es el tipo y la interrogacion nos avisa que puede ser nulo. Si pone v.view?  tenemos que ponerlo en el when
        //when es como im switch
        when (v?.id) {
            binding.botonIncremento.id -> {
                contador++
            }

            binding.botonDecremento.id-> {
                contador--
            }
            binding.botonPasar?.id -> {
                //no podemos crear una variable valr, constante, porque tenemos lateinit
                //al intent le ponemoe un bandle para que sea posible la transmision de datos de una pantalla a otra(?)
                val intent = Intent(applicationContext, SecondActivity::class.java) //entre los parentesis podemos meter OTRO intent
                intent.putExtra("contador", contador) // no tengo mu cklaro pa que es
                startActivity(intent) //pasa de pantalla
            }

        }
        //una vez recuperado el estado, se guarda en la variable del textoContador para que lo imprima por pantalla
        binding.textoContador.text = contador.toString()
    }
        //objerto de tipo Outstate, estado que se guarda cuando el estado se rompe. Lo recibe SavedInstanceState
        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            //se guarda con un parclave-valor
            outState.putInt("contador", contador)
            //vuelve a empezar el programa y vuelve a pasar por el onCreate, que deberá guardar los datos que le
            //envíe el ousState. Como????? Sube al OnCreate
            binding.textoContador.text = contador.toString();
        }

    //sacar avisos para mostrar el ciclo de vida


    override fun onStart(){
        super.onStart()
        Log.v("ciclo", "ejecutando onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo", "ejecutando onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo", "ejecutando onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo", "ejecutando onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo", "ejecutando onDestroy")
    }


    }






