package com.example.tema2.dataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (var contexto : Context, var dbname : String, var ncursos : SQLiteDatabase.CursorFactory, var versioon : Int ) : SQLiteOpenHelper(contexto, dbname, cursos, version) {
    //permite "llegar" a la base de datos, paramlo que hemos de xtenderla de un nobjeto que es SQiteOpenHelper
    override fun onCreate(db: SQLiteDatabase?) { // metodo abstracto obligatorio
        //se encarga de crear la bse de datos si no existe
        db?.execSQL("CREATE TABLE ${SchemaDB.TAB_NAME} (${SchemaDB.COL_ID} INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT, "
            + "${SchemaDB.COL_MARCA} TEXT, ${SchemaDB.COL_PRECIO} INTEGER, ${SchemaDB.COL_CV} INTEGER, ${SchemaDB.COL_IMAGEN} TEXT)") //db nulo poque puede que la base de datos no exista

    }

    override fun onUpgrade(db: SQLiteDatabase?, OldVersion: Int, NewVersion: Int) { // metodo abstracto obligatorio
        //actualiza la base de datos si la version es superior a la version actual
        TODO("Not yet implemented")
    }

    //METODOS QUE ACTUAN CONTRA LA BD -> CRUD

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {// metodo abstracto NO obligatorio
        super.onDowngrade(db, oldVersion, newVersion)
        //actualiza la base de datos si la version es inferior a la version actual

    }

}