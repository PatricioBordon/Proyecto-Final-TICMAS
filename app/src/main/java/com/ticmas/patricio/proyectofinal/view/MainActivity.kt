package com.ticmas.patricio.proyectofinal.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ticmas.patricio.proyectofinal.R
import com.ticmas.patricio.proyectofinal.databinding.CompararTextoBinding
import com.ticmas.patricio.proyectofinal.viewmodel.CompareViewModel

class MainActivity : ComponentActivity() {
    //Hice el curso complementario de 12 horas de AristiDevs de YouTube tambien

    private lateinit var binding: CompararTextoBinding
    private lateinit var compareViewModel: CompareViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= CompararTextoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
        initListeners()
        resultado()
    }

    private fun initComponents() {
        compareViewModel= ViewModelProvider(this).get(CompareViewModel::class.java)
    }
    private fun initListeners() {
        binding.btnComparar.setOnClickListener {
            compareViewModel.comparar(binding.etInput.text.toString(),binding.etInput2.text.toString())
        }
    }

    private fun resultado() {

        compareViewModel.Resultado.observe(this) { esIgual ->
            if(esIgual) binding.Resultado.text= "Ambas cadenas son iguales"
            else  binding.Resultado.text= "Ambas cadenas son distintas"
        }
    }
}
