package com.example.ec2_moviles2grupo5

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.example.ec2_moviles2grupo5.Commom.AppMensaje
import com.example.ec2_moviles2grupo5.Commom.TipoMensaje
import com.example.ec2_moviles2grupo5.databinding.ActivityFormularioBinding
import com.example.ec2_moviles2grupo5.databinding.ActivityMainBinding

class FormularioActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityFormularioBinding
    private var listaSintomas = ArrayList<String>()
    private var listaServicios = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // OnClick
        binding.btnResolver.setOnClickListener(this)
        binding.cbGustoOlfato.setOnClickListener(this)
        binding.cbTos.setOnClickListener(this)
        binding.cbGarganta.setOnClickListener(this)
        binding.cbCongestion.setOnClickListener(this)
        binding.cbFiebre.setOnClickListener(this)
        binding.cbNinguno.setOnClickListener(this)
        binding.cbLuz.setOnClickListener(this)
        binding.cbAgua.setOnClickListener(this)
        binding.cbInternet.setOnClickListener(this)
        binding.cbCable.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view is CheckBox){
            if(view.id == binding.cbNinguno.id || view.id == binding.cbCongestion.id || view.id == binding.cbFiebre.id || view.id == binding.cbGarganta.id || view.id == binding.cbGustoOlfato.id || view.id == binding.cbTos.id) {
                agregarQuitarSintomas(view)
            }
            if (view.id == binding.cbAgua.id || view.id == binding.cbCable.id || view.id == binding.cbInternet.id || view.id == binding.cbLuz.id){
                agregarQuitarServicios(view);
            };
        }else{
            when(view.id){
                R.id.btnResolver -> registroFormulario()
            }
        }
    }

    private fun registroFormulario() {
        if (validarRegistro()){
            //
            AppMensaje.enviarMensaje(binding.root,"Persona Registrada Correctamente", TipoMensaje.SUCCESSFULL)
            //
            val intentLista = Intent(
                this, ListarFormularioActivity::class.java
            ).apply {
                putExtra("listaFormulario",
                    "Síntomas: " + listaSintomas.toString() + "\n " +
                            "Fiebre: " + ObtenerFiebre() + "\n " +
                            "Vive Solo en Casa: " + ObtenerIndependencia() + "\n " +
                            "Vive Con Adulto Mayor: " + ObtenerAdultoMayor() + "\n " +
                            "Servicios: " +  (if (listaServicios.size == 0) "No cuenta con los Servicios Básicos"
                                              else listaServicios.toString() ))
            }
            startActivity(intentLista)
            //
            setearControles()
        }
    }

    private fun setearControles() {
        listaServicios.clear()
        listaSintomas.clear()
        binding.radioGroupAdulto.clearCheck()
        binding.radioGroupFiebre.clearCheck()
        binding.radioGroupIndependencia.clearCheck()
        binding.cbGustoOlfato.isChecked = false
        binding.cbTos.isChecked = false
        binding.cbGarganta.isChecked = false
        binding.cbCongestion.isChecked = false
        binding.cbFiebre.isChecked = false
        binding.cbNinguno.isChecked = false
        binding.cbLuz.isChecked = false
        binding.cbAgua.isChecked = false
        binding.cbInternet.isChecked = false
        binding.cbCable.isChecked = false
    }

    fun validarRegistro() : Boolean{

        var respuesta = false

        if (!validarSintomas()){
            AppMensaje.enviarMensaje(binding.root,
                "Seleccione al menos un sintoma", TipoMensaje.ERROR)
        }else if (!validarFiebre()){
            AppMensaje.enviarMensaje(binding.root,
                "Indique si tiene fiebre o no", TipoMensaje.ERROR)
        }else if (!validarIndependencia()){
            AppMensaje.enviarMensaje(binding.root,
                "Indique si vive solo en casa", TipoMensaje.ERROR)
        }else if (!validarAdulto()){
            AppMensaje.enviarMensaje(binding.root,
                "Indique si cuenta con un Adulto en casa", TipoMensaje.ERROR)
        }else{
            respuesta = true
        }
        return respuesta
    }

    fun validarFiebre(): Boolean {
        var respuesta = false;
        if(binding.rbSiFiebre.isChecked || binding.rbNoFiebre.isChecked) {
            respuesta = true;
        }
        return respuesta;
    }

    fun validarIndependencia(): Boolean {
        var respuesta = false;
        if(binding.rbSiIndependencia.isChecked || binding.rbNoIndependencia.isChecked) {
            respuesta = true;
        }
        return respuesta;
    }

    fun validarAdulto(): Boolean {
        var respuesta = false;
        if(binding.rbSiAdulto.isChecked || binding.rbNoAdulto.isChecked) {
            respuesta = true;
        }
        return respuesta;
    }

    fun validarSintomas(): Boolean {
        var respuesta = false;
        if(listaSintomas.size > 0) {
            respuesta = true;
        }
        return respuesta;
    }

    fun ObtenerFiebre(): String {
        var flag: String = "";
        when(binding.radioGroupFiebre.checkedRadioButtonId) {
            R.id.rbSiFiebre -> flag = "Tiene fiebre mayor a 37";
            R.id.rbNoFiebre -> flag = "No tiene fiebre mayor a 37";
        }
        return flag;
    }

    fun ObtenerIndependencia(): String {
        var flag: String = "";
        when(binding.radioGroupIndependencia.checkedRadioButtonId) {
            R.id.rbSiIndependencia -> flag = "Sí";
            R.id.rbNoIndependencia -> flag = "No";
        }
        return flag;
    }

    fun ObtenerAdultoMayor(): String {
        var flag: String = "";
        when(binding.radioGroupAdulto.checkedRadioButtonId) {
            R.id.rbSiAdulto -> flag = "Sí";
            R.id.rbNoAdulto -> flag = "No";
        }
        return flag;
    }

    private fun agregarQuitarSintomas(checkbox : CheckBox){
        if (checkbox.isChecked)
            listaSintomas.add(checkbox.text.toString())
        else{
            listaSintomas.remove(checkbox.text.toString())
        }
    }

    private fun agregarQuitarServicios(checkbox : CheckBox){
        if (checkbox.isChecked)
            listaServicios.add(checkbox.text.toString())
        else{
            listaServicios.remove(checkbox.text.toString())
        }
    }
}