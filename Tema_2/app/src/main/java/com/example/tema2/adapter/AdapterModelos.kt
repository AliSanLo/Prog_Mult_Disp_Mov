package com.example.tema2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tema2.R
import com.example.tema2.model.Coche

//Entre <...> nos pide un objheto del tipo MyHolder(?), por eso le pasamos "AdapterModelos.ModeloHolder"
//RecyclerView.Adapter<AdapterModelos.ModeloHolder>()  --> es una clase abstracta.
// Entonces NOS PIDE IMPLEMENTAR 3 METODOS que se crearan automaticamente:
        //a) onCreateViewHolder
        //b) getItemCount
        //c) onBindViewHolder
class AdapterModelos (var lista: ArrayList<Coche>, var contexto : Context) :RecyclerView.Adapter<AdapterModelos.ModeloHolder>() {

    //clase que representa el xml de item_modelo, que recibe un objeto de tipo "vista" que recibira un objeto de tipo "view" -> (vista:view),
    // que extenderá de RecyclerView.ViewHolder que por herencia recibe "vista" -> RecyclerView.ViewHolder (vista)
    class ModeloHolder (vista:View): RecyclerView.ViewHolder (vista){
        //extraer cada elemento del patron -> imagen, textview
         var imagenImageView: ImageView
         var textoTextView: TextView;

        //inicializamos las anteriores variables
        init {
            imagenImageView = vista.findViewById(R.id.imagen_fila)
            textoTextView = vista.findViewById(R.id.nombre_fila)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeloHolder { //segundo que hya que hacer de los tres
       // ATENCION, ASI ESTA MAL, porque tiodo lo que hay en R es de tipo numerico, devuelve numeros  ->   return ModeloHolder(R.layout.item_modelo)
       // ATENCION, ASI ESTA MAL, porque no podemos acceder a "resources" porque no estamos en una pantalla ni un modelo, sino un adaptador que necesita de una pantalla para funcionar -> return ModeloHolder(resource. ...)

        //creamos una variable de tipo view
        //con LayoutInflater traemos el fichero, pero como es numerico, con este metodo lo convertimos para poder llamarlo
        //entre parentesis pide el contexto, qeu es donde se estara ejecutando este AdaptadorModelos, la pantalla, pero una clase por si misa no puede coger un fichero. Necesita el contexto
        // PODRIA SER ASI -> val vista : VView = LayoutInflater.from(parent.context.applicationContext)
        //pero si el contexto queremos utilizarlo tambien en getItemCount, no nos sirve la anterior linea. Creamos en la linea de la clase AdapterModelos -> var contexto : Context
            val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_modelo, parent,false) // investigar el metodo inflate)

        return ModeloHolder(vista)
    }

    override fun getItemCount(): Int { //primero que hay que hacer de los tres
        //numero de elementos que tendra que adaptar. CREAMOS UN ARRAYLIST PARA PODER ALMACENAR ESTOS ELEMENTOS -> (var lista: ArrayList<Coche>
        return lista.size
    }

    override fun onBindViewHolder(holder: ModeloHolder, position: Int) {
        //representa cada elemento de la lista en su posicion utilizando el patron
        val item = lista[position]  // es como poner lista.getPosition en java, pa entendernos
        holder.textoTextView.text = item.nombre
        //cargamos la libreria Glide para poder sacar la imagen
        Glide.with(contexto).load(item.imagen).into(holder.imagenImageView)

    }
}