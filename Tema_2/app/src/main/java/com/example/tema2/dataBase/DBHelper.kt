package com.example.tema2.dataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.tema2.model.Coche
import javax.xml.validation.Schema

// Coge el nombre de la base de datos existente, no intenta crearla por defecto si el nombre que le damos no existe
class DBHelper(var contexto: Context, var dbName: String, var version: Int) :
    SQLiteOpenHelper(contexto, dbName, null, version) {
    // Permite "llegar" a la base de datos, para lo que hemos de extenderla de un objeto que es SQLiteOpenHelper
    override fun onCreate(db: SQLiteDatabase?) { // Método abstracto obligatorio
        // Se encarga de crear la base de datos si no existe
        db?.execSQL(
            "CREATE TABLE ${SchemaDB.TAB_NAME} (${SchemaDB.COL_ID} INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "${SchemaDB.COL_NAME} TEXT," +
                    "${SchemaDB.COL_MARCA} TEXT, ${SchemaDB.COL_PRECIO} INTEGER, " +
                    "${SchemaDB.COL_CV} INTEGER, ${SchemaDB.COL_IMAGEN} TEXT  )"
        )// DB nulo porque puede que la base de datos no exista
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) { // Método abstracto obligatorio
        // Actualiza la base de datos si la versión es superior a la versión actual
        TODO("Not yet implemented")
    }

    override fun onDowngrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {// Método abstracto NO obligatorio
        super.onDowngrade(db, oldVersion, newVersion)
        // Actualiza la base de datos si la versión es inferior a la versión actual
    }

    // Métodos que actúan contra la BD -> CUD
    // Acreación, actualización y borrado
    // Podemos llegar a la BD de dos formas: modo lectura y modo escritura
    fun agregarCoche(coche: Coche) {
        // Modo escritura
        val baseDatos = this.writableDatabase

        // Query INSERT into coche (nombre, marca, precio, cv, imagen) VALUES ('1','2','3','4','5')
        // baseDatos.execSQL()

        // Crear objeto de tipo content value
        val contentValue = ContentValues()
        contentValue.put(SchemaDB.COL_ID, coche.nombre)
        contentValue.put(SchemaDB.COL_MARCA, coche.marca)
        contentValue.put(SchemaDB.COL_CV, coche.cv)
        contentValue.put(SchemaDB.COL_IMAGEN, coche.imagen)

        baseDatos.insert(SchemaDB.TAB_NAME, null, contentValue)
    }

    fun getCoches(): ArrayList<Coche> {
        val baseDatos = this.readableDatabase
        val query = "SELECT * FROM ${SchemaDB.TAB_NAME}"
        val resultados = baseDatos.rawQuery(query, null)
        val listaResultado = ArrayList<Coche>()

        while (resultados.moveToNext()) {
            val posicionNombre = resultados.getColumnIndex(Schema.COL_NAME)
            val nombre = resultados.getString(posicionNombre)
            val posicionMarca = resultados.getColumnIndex(Schema.COL_MARCA)
            val marca = resultados.getString(posicionMarca)
            val posicionPrecio = resultados.getColumnIndex(Schema.COL_PRECIO)
            val precio = resultados.getInt(posicionPrecio)
            val posicionImagen = resultados.getColumnIndex(Schema.COL_IMAGEN)
            val imagen = resultados.getInt(posicionImagen)
            val posicionCV = resultados.getColumnIndex(Schema.COL_CV)
            val cv = resultados.getString(posicionCV)
            Coche(nombre, marca, precio, imagen, cv)
        }
        return ListaResultado
    }
}

