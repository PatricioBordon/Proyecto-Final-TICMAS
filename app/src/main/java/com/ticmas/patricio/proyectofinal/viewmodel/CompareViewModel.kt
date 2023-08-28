package com.ticmas.patricio.proyectofinal.viewmodel

import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ticmas.patricio.proyectofinal.model.CompareModel
import java.util.Locale

class CompareViewModel : ViewModel(){
    private val resultado= MutableLiveData<Boolean>()
    val Resultado: LiveData<Boolean>
        get()= resultado
    fun comparar(texto1: String, texto2: String){
        var res: Boolean= false
        if(texto1.lowercase(Locale.ROOT).trim()==texto2.lowercase(Locale.ROOT).trim()){
            res= true
        }
        resultado.value= res
    }
}
