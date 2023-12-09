package com.example.tema2.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.tema2.R
import com.example.tema2.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar
import java.text.FieldPosition

class SecondActivity : AppCompatActivity() {

    //PRIMERO: el binding. HAY QUE HACERLO SIEMPRE
    private lateinit var binding : ActivitySecondBinding
    //parte de datos de mi lista


    //PARTE DE DATOS DE MI LISTA
    //entre los <...> añadimos el tipo de los elementos de la lista
   private lateinit var adaptadorLista: ArrayAdapter<Coche>
/*
    private lateinit var adapterModelos: AdapterModelos
    private lateinit var openHelper: DBHelper;*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //segundo: hACEMOS EL INFLADO
        binding = ActivitySecondBinding.inflate(layoutInflater)
        //tercero: setteo el binding dentro de la parte grafica
        setContentView(binding.root)

        //Declaramos el arraylist
        val listaCoches : ArrayList <Coche> = ArrayList();
        //inicializamos la lista
        listaCoches.add((Coche("Mondeo", 10000, 150, 0)))
        listaCoches.add((Coche("Ibiza", 7766, 456, 0)))
        listaCoches.add((Coche("Leon", 234, 854, 0)))
        listaCoches.add((Coche("Fiesta", 553453, 268, 0)))
        listaCoches.add((Coche("Focus", 765756, 3333, 0)))

        //ADAPTADOR PARA QUE LA LISTA PUEDA SALIR POR PATNALLA: Entre parentesis: contexto (ctx), layout, lista de datos a mostrar
        adaptadorLista= ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, listaCoches);
        binding.listViewModelos.adapter = adaptadorLista

        /*CUARTO: capturamos el usuario, en concreto el ".nombre". Hemos pasado un objeto que esta señalado en el main activity
        (       intent.putExtra("usuario", Usuario (binding.editUser.toString(), binding.editPass.toString()))     )
        Pero cuando capturamos datos de un EditText, no podemos quedarnos solo con ".editU  suario", hay que añadir el ".text" para seleccionar el texto que  esta dentro del toString */
//un metodo tachado significa que esta deprecado, es decir, que exziste otro metodo que funciona mejor que ese.
        //si no me pasan nombre de usuario,ponemos null
                binding.nombreUsuario.text = (intent.extras?.getSerializable("usuario") as Usuario).nombre
        binding.nombreUsuario

        binding.spinnerMarcas.onItemSelectedListener = object : OnItemSelectedListener {
            //si pulso y selecciono un elemento que si se ejecutará (ej.: selecciono una marca de coche), se ejecutara  onItemSelected
            override fun onItemSelected(
                //el qeu ha provocado el evento, el spinner, en este caso
                parent: AdapterView<*>?,
                //la fila que se ha pulsado
                view: View?,
                //posicion pulsada del spinner
                position: Int,
                //id asociado en la posicion pulsada. Efectivo sobre todo si trabajamos cno base de datos
                id: Long
            ) {
                Snackbar.make(binding.root, binding.spinnerMarcas.selectedItem.toString(), Snackbar.LENGTH_SHORT)
                .show()
                //vanmos al padre, que ha generado el evento, seleccionamos su parte de datos, el adapter y
                //de ahi escoge el que esta en una posicion concreta. (no se por qué no lo usa y lo comenta):
                /* parent?.adapter?.getItem(position).toString()
                    binding.spinnerMarcas.selectedItem*/




            }

            //no cambia la seleccion aunque clickee asi que hay que hacer lo siguiente
            //pero si seleccionoy cliekeo y si que selecciono habra que crear un ItemSlected
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

//setOn es un método, pero onItem es una propiedad
       /* binding.botonFiltrar.setOnClickListener{
        binding.spinnerMarcas.selectedItem*/
override fun onStart() {
    super.onStart()
}
}