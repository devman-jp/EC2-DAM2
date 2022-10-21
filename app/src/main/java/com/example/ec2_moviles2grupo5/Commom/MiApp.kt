package com.example.ec2_moviles2grupo5.Commom

import android.app.Application

class MiApp : Application(){

    companion object{
        lateinit var  instance : MiApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}