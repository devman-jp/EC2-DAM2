package com.example.ec2_moviles2grupo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ec2_moviles2grupo5.databinding.ActivityListarFormularioBinding

class ListarFormularioActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListarFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val datos = bundle?.getString("listaFormulario")
        val enviar = binding.txtDataFormulario
        enviar.text = datos.toString()
    }
}