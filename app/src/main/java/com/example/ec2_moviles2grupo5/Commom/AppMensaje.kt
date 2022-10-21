package com.example.ec2_moviles2grupo5.Commom

import android.view.View
import androidx.core.content.ContextCompat
import com.example.ec2_moviles2grupo5.R
import com.google.android.material.snackbar.Snackbar

object AppMensaje {

    fun enviarMensaje(vista : View, mensaje: String, tipo: TipoMensaje){

        val snackbar = Snackbar.make(vista,mensaje, Snackbar.LENGTH_LONG)
        val snackBarView : View = snackbar.view
        if (tipo == TipoMensaje.ERROR){
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(MiApp.instance, R.color.snackbarerror)
            )
        }else{
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(MiApp.instance, R.color.snackbarsuccess)
            )
        }
        snackbar.show()
    }
}