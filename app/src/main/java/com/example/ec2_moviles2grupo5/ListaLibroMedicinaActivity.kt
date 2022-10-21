package com.example.ec2_moviles2grupo5

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.ec2_moviles2grupo5.databinding.ActivityListaLibroMedicinaBinding

class ListaLibroMedicinaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListaLibroMedicinaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaLibroMedicinaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val libros = arrayOf(
            "TITULO :Anatomía Con Orientación Clínica, 8.a \n" +
                    "DESCRIPCION:Anatomía con orientación clínica proporciona a estudiantes de medicina y otras áreas afines la información anatómica que necesitan para su formación teórica y práctica\n" +
                    "FECHA:2011\n",
            "TITULO :Atlas de Anatomía Humana\n" +
                    "DESCRIPCION:Nueva edición del atlas de anatomía humana concebido desde una perspectiva clínica gracias a las incomparables ilustraciones Netter y “estilo Netter\" de la mano del magnífico ilustrador, Carlos Machado.\n" +
                    "FECHA:1989\n",
            "TITULO :Medicina de urgencias y emergencias\n" +
                    "DESCRIPCION:En esta nueva edición de Medicina de urgencias emergencias se llevará a cabo una revisión exhaustiva del contenido, sobre todo en aquellos aspectos relacionados con el diagnóstico y el tratamiento, siempre recogiendo la evidencia más actual.\n" +
                    "FECHA:1999\n",
            "TITULO :El libro de la medicina\n" +
                    "DESCRIPCION:¿Cómo se diagnostican las enfermadades? ¿Qué es el cáncer? ¿Por qué algunas pandemias son tan mortíferas? Este libro responde estas y otras muchas preguntas, explorando y explicando los logros y hallazghos que han configurado nuestra visión moderna de la medicina y nos ayudan a proteger y promover nuestra salud.\n" +
                    "FECHA:2 de noviembre de 2021\n",
            "TITULO :Flashcards de Farmacología básica\n" +
                    "DESCRIPCION:Texto, que a pesar de ser una 5a ed en inglés, es una novedad editorial en nuestro portfolio, ya que viene a cubrir la asignatura de farmacología básica en el grado de medicina\n" +
                    "FECHA:15 de mayo de 2019\n",
            "TITULO :ADAMS Y VICTOR PRINCIPIOS DE NEUROLOGIA\n" +
                    "DESCRIPCION:Da al especialista y al estudioso toda la información que necesitan para solucionar problemas neurológicos desconcertantes, desde discinesias y trastornos del intelecto, la conducta y el lenguaje, hasta enfermedades degenerativas y neuromusculares.?\n" +
                    "FECHA: 23 de noviembre de 2010\n",
            "TITULO :El emperador de todos los males: una biografía del cáncer\n" +
                    "DESCRIPCION:El Emperador de Todas los males: Una Biografía del Cáncer es un libro escrito por Siddhartha Mukherjee, médico y oncólogo estadounidense nacido en la India\n" +
                    "FECHA:16 de noviembre de 2010\n",
            "TITULO :Neuroética: Una guía multifacética\n" +
                    "DESCRIPCION:una guía multifacética, enfoca su atención en el uso de las neurociencias, neuroinformación, neurotecnologías, y neurotécnicas novedosas (neuroCITT), cuyos fines han sobrepasado su relación con el sector de la salud.\n" +
                    "FECHA:2020\n",
            "TITULO :El tratamiento farmacológico en Psiquiatría\n" +
                    "DESCRIPCION:En un momento de importantes cambios en la práctica clínica psicofarmacológica, la segunda edición de esta obra, ofrece un actualizado enfoque sobre la evidencia de la farmacoterapia de las afecciones más frecuentes, que jerarquiza ahora los nuevos ensayos clínicos \"del mundo real\", concebidos con criterios de inclusión muy amplios, con una especial atención en la detección de las fallas terapéuticas y con financiación gubernamental que ahuyenta la sospecha de potenciales de intereses sobre los resultados informados.\n" +
                    "FECHA:2005\n",
            "TITULO :Sabiston. Tratado de cirugía\n" +
                    "DESCRIPCION:La 20a edición de este clásico en cirugía general mantiene el mismo objetivo que las ediciones previas: seguir siendo un referente, basado en la evidencia, para todos los profesionales del ámbito quirúrgico y convertirse en una de las principales fuentes de información de formación clínica en todas las áreas de la cirugía general.\n" +
                    "FECHA:2000\n"


        )


        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, libros)
        binding.lstLibroMedicina.adapter = adapter
    }
}