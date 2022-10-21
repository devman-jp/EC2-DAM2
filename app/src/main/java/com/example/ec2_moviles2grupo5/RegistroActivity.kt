package com.example.ec2_moviles2grupo5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.core.util.PatternsCompat
import com.example.ec2_moviles2grupo5.Commom.AppMensaje
import com.example.ec2_moviles2grupo5.Commom.TipoMensaje
import com.example.ec2_moviles2grupo5.databinding.ActivityRegistroBinding
import java.util.regex.Pattern

class RegistroActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityRegistroBinding
    private  val listahobbies = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        binding.btnRegistrar.setOnClickListener(this)
        binding.cbDeporte.setOnClickListener(this)
        binding.cbPintura.setOnClickListener(this)
        binding.cbOtro.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view is CheckBox){
            agregarQuitarhobbies(view)
        }else{
            when(view.id){
                R.id.btnRegistrar -> registroPersona()
            }
        }
    }

    private fun registroPersona() {
        if (validarRegistro()){
            //
            AppMensaje.enviarMensaje(binding.root,"Persona Registrada Correctamente", TipoMensaje.SUCCESSFULL)
            //
            val intentLista = Intent(
                this, ListadoRegistroActivity::class.java
            ).apply {
                putExtra("listaregistro",
                    "DNI: " + binding.etDni.text.toString() + "\n " +
                            "Nombre: " + binding.etNombre.text.toString() + "\n " +
                            "Apellidos: " + binding.etApellidos.text.toString() + "\n " +
                            "Email: " + binding.etEmail.text.toString() + "\n " +
                            "Password: " + binding.etPassword.text.toString() + "\n " +
                            "Sexo: " + obtenerSexoSeleccionado() + "\n " +
                            "Hobbies: " +  (if (listahobbies.size == 0) binding.edtHobby.text.toString()
                    else listahobbies.toString() + " " + binding.edtHobby.text.toString()))
            }
            startActivity(intentLista)
            //
            setearControles()
        }
    }

    private fun setearControles(){
        listahobbies.clear()
        binding.etDni.setText("")
        binding.etNombre.setText("")
        binding.etApellidos.setText("")
        binding.etEmail.setText("")
        binding.etPassword.setText("")
        binding.radioGroup.clearCheck()
        binding.cbDeporte.isChecked = false
        binding.cbPintura.isChecked = false
        binding.cbOtro.isChecked = false
        binding.edtHobby.setText("")
        binding.etDni.isFocusableInTouchMode = true
        binding.etDni.requestFocus()

    }

    fun validarRegistro() : Boolean{

        var respuesta = false

        if (!validarDni()){
            AppMensaje.enviarMensaje(binding.root,
            "Ingrese su Dni de 8 Digitos", TipoMensaje.ERROR)
        }else if (!validarNombreApellido()){
            AppMensaje.enviarMensaje(binding.root,
            "Ingrese su Nombre y Apellidos", TipoMensaje.ERROR)
        }else if (!validarEmail()){
            AppMensaje.enviarMensaje(binding.root,
            "Ingrese su email con el formato correcto", TipoMensaje.ERROR)
        }else if (!validarPassword()){
            AppMensaje.enviarMensaje(binding.root,
            "Ingrese una Contraseña valida", TipoMensaje.ERROR)
        }else if (!validarsexo()){
            AppMensaje.enviarMensaje(binding.root,
            "Seleccione su Sexo", TipoMensaje.ERROR)
        }else if (!validarHobbie()){
            AppMensaje.enviarMensaje(binding.root,
            "Seleccion su Hobbie o escriba su Hobbie", TipoMensaje.ERROR)
        }else{
            respuesta = true
        }
        return respuesta
    }

    fun validarDni() : Boolean{
        var respuesta = true
        if (binding.etDni.text.toString().trim().isEmpty()){
            binding.etDni.isFocusableInTouchMode = true
            binding.etDni.requestFocus()
            respuesta = false
        }else if (binding.etDni.text.toString().length < 8){
            binding.etDni.isFocusableInTouchMode = true
            binding.etDni.requestFocus()
            respuesta = false
        }
        return  respuesta
    }

    fun validarNombreApellido() : Boolean{
        var respuesta = true
        if (binding.etNombre.text.toString().trim().isEmpty()){
            binding.etNombre.isFocusableInTouchMode = true
            binding.etNombre.requestFocus()
            respuesta = false
        }else if (binding.etApellidos.text.toString().trim().isEmpty()){
            binding.etApellidos.isFocusableInTouchMode = true
            binding.etApellidos.requestFocus()
            respuesta = false
        }
        return respuesta
    }

    fun validarEmail() : Boolean{
        var respuesta = true
        if (binding.etEmail.text.toString().trim().isEmpty()){
            binding.etEmail.isFocusableInTouchMode = true
            binding.etEmail.requestFocus()
            respuesta = false
        }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()){
            binding.etEmail.isFocusableInTouchMode = true
            binding.etEmail.requestFocus()
            respuesta = false
        }
        return  respuesta
    }

    fun validarPassword() : Boolean{
        var respuesta = true
        val passwordpatron = Pattern.compile(
            "^" +
                    "(?=.*[0-9])" + //1 digito numerico
                    "(?=\\S+$)" + //no debe tener espacio
                    ".{4,}" + //4 caracteres como minimo
                    "$"

        )
        if (binding.etPassword.text.toString().trim().isEmpty()){
            binding.etPassword.isFocusableInTouchMode = true
            binding.etPassword.requestFocus()
            respuesta = false
        }else if (!passwordpatron.matcher(binding.etPassword.text.toString()).matches()){
            binding.etPassword.isFocusableInTouchMode = true
            binding.etPassword.requestFocus()
            respuesta = false
        }
        return  respuesta
    }

    fun validarsexo() : Boolean{
        var respuesta = true
        if (binding.radioGroup.checkedRadioButtonId == -1){
            respuesta = false
        }
        return  respuesta
    }

    fun obtenerSexoSeleccionado() : String {
        var sexo = ""
        when(binding.radioGroup.checkedRadioButtonId){
            R.id.rbHombre -> sexo = binding.rbHombre.text.toString()
            R.id.rbMujer -> sexo = binding.rbMujer.text.toString()
        }
        return sexo
    }

    fun validarHobbie() : Boolean{
        var respuesta = false
        if (binding.cbDeporte.isChecked || binding.cbPintura.isChecked || binding.cbOtro.isChecked || binding.edtHobby.text.trim().length > 1){
            respuesta = true
        }
        return  respuesta
    }

    private fun agregarQuitarhobbies(checkbox : CheckBox){
        if (checkbox.isChecked)
            listahobbies.add(checkbox.text.toString())
        else{
            listahobbies.remove(checkbox.text.toString())
        }
    }

}