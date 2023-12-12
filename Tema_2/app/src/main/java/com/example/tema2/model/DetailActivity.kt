package com.example.tema2.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.tema2.R
import com.example.tema2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private lateinit var coche : Coche


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // aseguramos con  "!!" que no va a ser nulo, si o si pasa informacion (?)
        coche = intent.extras!!.getSerializable("coche") as Coche // HAY QUE CASTEARLO A LO QUE INDIQUE

        Glide.with(applicationContext)
            .load(coche.imagen)
            //.load("https://hips.hearstapps.com/hmg-prod/images/2021-ford-focus-st-outdoor-02-1634285517.jpg")
            .placeholder(R.drawable.ups_no_hay_coche)
            .into(binding.imagenModelo)
      // binding.imagenModelo.setImageResource(coche.imagen)
        binding.nombreModelo.text=coche.nombre

    }

}
