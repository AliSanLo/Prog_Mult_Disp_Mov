package com.example.tema2.Data

import android.annotation.SuppressLint
import com.example.tema2.model.Coche

class DataSet {

    //representa el conjunto de datos que tenemos por defecto
    /*
    listaCoches.add(Coche("Mondeo",  150, 0,"https://www.diariomotor.com/imagenes/2012/10/fordvignale_mondeo_4door_01.jpg" ))
    listaCoches.add(Coche("Focus",  3333, 0, "https://www.autonocion.com/wp-content/uploads/2021/11/ford_focus_st_970.jpeg"))
    listaCoches.add(Coche("Ibiza",  456, 0, "https://s1.eestatic.com/2021/07/21/motor/598203379_195864785_1706x960.jpg"))
    listaCoches.add(Coche("Leon", 854, 0, "https://static.motor.es/fotos-noticias/2012/02/seat-leon-cupra-r-y-leon-cupra_4.jpg"))
    listaCoches.add(Coche("Fiesta", 268, 0, "https://hips.hearstapps.com/es.h-cdn.co/cades/contenidos/13225/fordfiesta201301.jpg"))
*/

    //método que pertenezca a la clase y no al objeto. Seria un metodo estatico, pero no existe en kotlin, asi que se usan los Companion
companion object {
    fun getAllModelos (): ArrayList <Coche>{
        var listaCoches = ArrayList <Coche>()
            listaCoches.add(Coche("Mondeo","Ford",5454,  150, "https://www.diariomotor.com/imagenes/2012/10/fordvignale_mondeo_4door_01.jpg"))
            listaCoches.add(Coche("Focus",  "Ford", 46534, 64565,"https://www.autonocion.com/wp-content/uploads/2021/11/ford_focus_st_970.jpeg"))
            listaCoches.add(Coche("Ibiza",  "Mercedes", 10000, 564,"https://s1.eestatic.com/2021/07/21/motor/598203379_195864785_1706x960.jpg"))
            listaCoches.add(Coche("Leon", "Opel", 34340, 56, "https://static.motor.es/fotos-noticias/2012/02/seat-leon-cupra-r-y-leon-cupra_4.jpg"))
            listaCoches.add(Coche("Fiesta", "Mercedes", 457735, 5456, "https://hips.hearstapps.com/es.h-cdn.co/cades/contenidos/13225/fordfiesta201301.jpg"))
return listaCoches
        }
        }}

