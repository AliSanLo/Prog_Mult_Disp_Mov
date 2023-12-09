package com.example.tema2.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tema2.Data.DataSet
import com.example.tema2.R
import com.example.tema2.adapter.AdapterModelos
import com.example.tema2.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    //PRIMERO: el binding. HAY QUE HACERLO SIEMPRE
    private lateinit var binding: ActivitySecondBinding

    //PARTE DE DATOS DE MI LISTA
    //entre los <...> añadimos el tipo de los elementos de la lista
    private lateinit var adaptadorLista: ArrayAdapter<Coche>
    private lateinit var adapterModelos :AdapterModelos
    /*
        private lateinit var adapterModelos: AdapterModelos
        private lateinit var openHelper: DBHelper;*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //segundo: hACEMOS EL INFLADO
        binding = ActivitySecondBinding.inflate(layoutInflater)
        //tercero: setteo el binding dentro de la parte grafica
        setContentView(binding.root)



        //ADAPTADOR PARA QUE LA LISTA PUEDA SALIR POR PATNALLA: Entre parentesis: contexto (ctx), layout, lista de datos a mostrar
        //DEJAMOS DE UTILIZARLO -> adaptadorLista = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, DataSet.getAllModelos());
        //DEJAMOS DE UTILIZARLO -> adaptadorLista = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, DataSet.getAllModelos());

        //lo primero que pasamos por constructor es la lista y el contexto. La lista la sacamos de DataSet.
        //Con respecto al contexto, si queremos utilizar interfaces de callback "applicationContext" es "demasiado bestia". Entonces deberiamos pasarle "this", mas simple y efectivo.
adapterModelos = AdapterModelos(DataSet.getAllModelos(), applicationContext)
        //le asociamos los datos
        binding.recyclerModelos.adapter= adapterModelos
        binding.recyclerModelos.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)//linear, gridLayout o que lo muestre en un numerod e columnas determinado, o staggered






       // LA SIGUIENTE LINEA FUNCIONA CON LISTVIEW, PERO NO CON RECYCLER VIEW
        //  binding.listViewModelos.adapter = adaptadorLista;


        /*CUARTO: capturamos el usuario, en concreto el ".nombre". Hemos pasado un objeto que esta señalado en el main activity
        (       intent.putExtra("usuario", Usuario (binding.editUser.toString(), binding.editPass.toString()))     )
        Pero cuando capturamos datos de un EditText, no podemos quedarnos solo con ".editU  suario", hay que añadir el ".text" para seleccionar el texto que  esta dentro del toString */
//un metodo tachado significa que esta deprecado, es decir, que exziste otro metodo que funciona mejor que ese.
        //si no me pasan nombre de usuario,ponemos null
        binding.nombreUsuario.text = (intent.extras?.getSerializable("usuario") as Usuario).nombre


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
                Snackbar.make(
                    binding.root,
                    binding.spinnerMarcas.selectedItem.toString(),
                    Snackbar.LENGTH_SHORT
                )
                    .show()

                val marcaSeleccionada = parent!!.adapter.getItem(position).toString()
                //lo siguiente es un iterable que se convierte en un ArrayList de tipo Coche
                val listaFiltrada = DataSet.getAllModelos()
                    .filter { it.marca.equals(marcaSeleccionada, true) } as ArrayList<Coche>

                //YA NO SIRVE
               // adaptadorLista.clear()
                //adaptadorLista.addAll(listaFiltrada)


                //vanmos al padre, que ha generado el evento, seleccionamos su parte de datos, el adapter y
                //de ahi escoge el que esta en una posicion concreta. (no se por qué no lo usa y lo comenta):
                /* parent?.adapter?.getItem(position).toString()
                    binding.spinnerMarcas.selectedItem*/


            }


            //no cambia la seleccion aunque clickee asi que hay que hacer lo sigu iente
            //pero si seleccionoy cliekeo y si que selecciono habra que crear un ItemSlected
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    /*


    LO SIGUIENTE ES LO QUE FUNCIONA CON LISTVIEW, PERO NO CON RECYCLER VIEW


        binding.listViewModelos.setOnItemClickListener { parent, view, position, id ->
            //Para que aparezca el precio al pinchar en el coche:
            // Snackbar.make(binding.root, "${resources.getString(R.string.mensaje)} "  + listaCoches[position].precio.toString(), Snackbar.LENGTH_SHORT).show()


            //detectar la pulsacion
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("coche", DataSet.getAllModelos()[position]) // el profesor pone aqui
            startActivity(intent)
        }
        /*binding.listViewModelos.setOnLongClickListener{
            Snackbar.make(binding.root, (binding.listViewModelos.selectedItem as Coche).precio.toString(), Snackbar.LENGTH_SHORT).show()
           return@setOnLongClickListener true
        }*/

*/


    }

    override fun onStart() {
        super.onStart()
    }

}


//setOn es un método, pero onItem es una propiedad
/* binding.botonFiltrar.setOnClickListener{
 binding.spinnerMarcas.selectedItem*/



