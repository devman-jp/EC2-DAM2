package com.example.ec2_moviles2grupo5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ec2_moviles2grupo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegistro.setOnClickListener (this)
        binding.btnFormulario.setOnClickListener(this)
        binding.btnListarMedicina.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnRegistro ->{
                iraRegistro()
            }

            R.id.btnFormulario ->{
                iraFormulario()
            }

            R.id.btnListarMedicina ->{
                iraListadoMedicina()
            }
        }
    }

    fun iraRegistro(){
        val intent = Intent (this, RegistroActivity::class.java)
        startActivity(intent)
    }

    fun iraFormulario(){
        val intent = Intent( this, FormularioActivity::class.java)
        startActivity(intent)

    }

    fun iraListadoMedicina(){
        val intent = Intent( this, ListaLibroMedicinaActivity::class.java)
        startActivity(intent)

    }


}