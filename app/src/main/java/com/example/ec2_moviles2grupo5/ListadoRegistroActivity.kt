package com.example.ec2_moviles2grupo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.R
import com.example.ec2_moviles2grupo5.databinding.ActivityListadoRegistroBinding

class ListadoRegistroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListadoRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  listaregistro = intent.getSerializableExtra("listaregistro") as ArrayList<String>
        val  adapter = ArrayAdapter(this, R.layout.simple_list_item_1, listaregistro)
        binding.lvListadoRegistro.adapter = adapter
    }
}