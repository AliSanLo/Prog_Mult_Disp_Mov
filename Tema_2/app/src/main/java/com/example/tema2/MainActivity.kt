package com.example.tema2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tema2.databinding.ActivityMainBinding
import com.example.tema2.model.SecondActivity
import com.example.tema2.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonLogin.setOnClickListener {
            //capturar el dato accediento al biding
            if (binding.editUser.text.toString().equals("Admin", true)
                && binding.editPass.text.toString().equals("admin")
            ) {
                //voy a pasar de pantalla
                val intent = Intent(applicationContext, SecondActivity::class.java)
                intent.putExtra(
                    "usuario",
                    Usuario(binding.editUser.text.toString(), binding.editPass.text.toString())
                )// Se pasa a una segunda pantalla con una serie de datos
                startActivity(intent)
            } else {
                //snackbar
                Snackbar.make(binding.root, "Error en los datos", Snackbar.LENGTH_SHORT).show()
            }

        }
    }

}
