package com.example.tema2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tema2.Data.DataSet
import com.example.tema2.R
import com.example.tema2.model.Coche
import com.example.tema2.model.DetailActivity


//AL TRABAJAR ON UN RECYCLER vIEW NECESITAMOS UN ADAPTADOR Y OBLIGATORIAMETNE CERAMOS ESTA CLASE.
//a PARTIR DE AQUI CREAMOS TAMBIEN item_modelo.xml

//Entre <...> nos pide un objheto del tipo MyHolder(?), por eso le pasamos "AdapterModelos.ModeloHolder"
//RecyclerView.Adapter<AdapterModelos.ModeloHolder>()  --> es una clase abstracta.
// Entonces NOS PIDE IMPLEMENTAR 3 METODOS que se crearan automaticamente:
        //a) onCreateViewHolder
        //b) getItemCount
        //c) onBindViewHolder
class AdapterModelos (var lista: ArrayList<Coche>, var contexto : Context) :RecyclerView.Adapter<AdapterModelos.ModeloHolder>() {

    //clase que representa el xml de item_modelo, que recibe un objeto de tipo "vista" que recibira un objeto de tipo "view" -> (vista:view),
    // que extenderá de RecyclerView.ViewHolder que por herencia recibe "vista" -> RecyclerView.ViewHolder (vista)

    //el contenido del xml item_modelo.xml será gestionado por la siguiente clase
    class ModeloHolder (vista:View): RecyclerView.ViewHolder (vista){ //por herencia recibe la vista
        //extraer cada elemento del patron o holder -> imagen, textview
         var imagenImageView: ImageView
         var textoTextView: TextView;

        //inicializamos las anteriores variables
        init {
            imagenImageView = vista.findViewById(R.id.imagen_fila)
            textoTextView = vista.findViewById(R.id.nombre_fila)

        }
    }



    override fun getItemCount(): Int { //primero que hay que hacer de los tres
        //numero de elementos que tendra que adaptar. CREAMOS UN ARRAYLIST PARA PODER ALMACENAR ESTOS ELEMENTOS -> (var lista: ArrayList<Coche>
        return lista.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeloHolder { //segundo que hya que hacer de los tres
        //como se crea el patron
        // ATENCION, ASI ESTA MAL, porque tiodo lo que hay en R es de tipo numerico, devuelve numeros  ->   return ModeloHolder(R.layout.item_modelo)
        // ATENCION, ASI ESTA MAL, porque no podemos acceder a "resources" porque no estamos en una pantalla ni un modelo, sino un adaptador que necesita de una pantalla para funcionar -> return ModeloHolder(resource. ...)

        //creamos una variable de tipo view
        //con LayoutInflater traemos el fichero, pero como es numerico, con este metodo lo convertimos para poder llamarlo
        //entre parentesis pide el contexto, qeu es donde se estara ejecutando este AdaptadorModelos, la pantalla, pero una clase por si misa no puede coger un fichero. Necesita el contexto
        // PODRIA SER ASI -> val vista : VView = LayoutInflater.from(parent.context.applicationContext)
        //EN EL CASO DE LA LINEA ANTERIOR: Por qué parent? ES UN ARGUMENTO DE ESTE METODO. Si lo utilizamos ya no
       // podríamos utilizar esta linea de codigo para que se aplique a otras aprtes del programa.
        //pero si el contexto queremos utilizarlo tambien en getItemCount, no nos sirve la anterior linea. Creamos en la linea de la clase AdapterModelos -> var contexto : Context
        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_modelo, parent,false) // investigar el metodo inflate)

        return ModeloHolder(vista)
    }
    override fun onBindViewHolder(holder: ModeloHolder, position: Int) {
        //representa cada elemento de la lista en su posicion utilizando el patron
        val item = lista[position]  // es como poner lista.getPosition en java, pa entendernos
        //representar cada elemento
        holder.textoTextView.text = item.nombre
        //cargamos la libreria Glide para poder sacar la imagen
        Glide.with(contexto).load(item.imagen).into(holder.imagenImageView)

        //SI QUEREMOS GESTIONAR LAS PULSACIONES DE LOS RECYCLERVIEWS, LO HACEMOS ASI:
        holder.imagenImageView.setOnClickListener({//pulsacion en la imagen
//PARA PASAR DE PAGINA AL PULSAR LA IMAGEN:
            val intent = Intent(contexto, DetailActivity::class.java)
            intent.putExtra("coche", DataSet.getAllModelos()[position]) // el profesor pone aqui
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) /*si no añadimos esta linea no funciona, porque realmente no cambiamos de pantalla
         desde una pantalla, sino desde el adaptador. El adaptador tendra qeu comunicarse con la pantalla y  la pantalla arrancará*/
            contexto.startActivity(intent)   //ESTE "intent"NO HAY QUE HACERLO MEDIANTE EL ADAPTADOR, SINO MEDIANTE EL CONTEXTO
        })
    }
}