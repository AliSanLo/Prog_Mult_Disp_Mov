package com.example.practica_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    /*Declaración de la variable botonPulsar como lateinit:
    lateinit se utiliza para indicar que la inicialización de la variable se realizará en algún momento después
    de la declaración, pero antes de que se utilice. En este caso, el botón se inicializará más adelante en el método onCreate.
    lateinit var botonPulsar : Button; //lateiniit porque hasta que no se asocie mas abajo, no funciona*/

    /*Método onCreate:
    * *Este método se llama cuando la actividad está siendo creada. En él, se establece el contenido de la actividad con
    el diseño definido en activity_main.xml./
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Acceso a los elementos gráficos:
        * Aquí, se obtiene la referencia al botón desde el diseño XML utilizando findViewById. La referencia se asigna a la
        *  variable botonPulsar.*/
        botonPulsar = findViewById(R.id.boton_pulsar);

        /*Configuración del listener del botón:
        * Se configura un listener para el botón utilizando setOnClickListener. Cuando el botón se presiona, se muestra un
        * Snackbar con el mensaje "Práctica completada" y una duración corta*/
        botonPulsar.setOnClickListener {
            Snackbar.make(it, "practica completada", Snackbar.LENGTH_SHORT).show()
        }


    }
}