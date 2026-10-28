package com.example.appcursos.Presentador


import com.example.appcursos.Modelo.clsCarrerasModelo
import com.example.appcursos.Modelo.clsEstadoInscripcionModelo
import com.example.appcursos.Modelo.dataCarreras
import com.example.appcursos.Vista.EstadoRegistroActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class clsEstadoInscripcionPresentador(val vista: EstadoRegistroActivity) {
    private val modeloCarreras = clsCarrerasModelo()
    private val modeloInscripciones = clsEstadoInscripcionModelo()
    private var listCarreras : List<dataCarreras> = emptyList()

    fun iniciar()
    {
        CoroutineScope (Dispatchers.Main).launch{
            try{
                listCarreras = modeloCarreras.obtenerCarreras()
                vista.mostrarCarreras(listCarreras)
            }catch (e: Exception)
            {
                vista.mostrarError("Error" + e.localizedMessage)
            }
        }
    }
    fun seleccionarCarrera(position: Int)
    {
        if (position >= 0 && position< listCarreras.size)
        {
            val curso =listCarreras[position]
            cargarCurso(curso.id)
        }

    }
    private fun cargarCurso(idCarrera: Int)
    {
        CoroutineScope (Dispatchers.Main).launch{
            try{
                val cursos = modeloInscripciones.obtenerInscripcionesPorCarrera(idCarrera)
                vista.mostrarCursos(cursos)
            }catch (e: Exception){
                vista.mostrarError("Error al cargar los cursos: "+ e.localizedMessage)
            }
        }
    }
    fun volver()
    {
        vista.abrirCatalogoCursos()
    }
    fun obtenerCursosPorCarrera(idCarrera: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val listaCursos = modeloInscripciones.obtenerInscripcionesPorCarrera(idCarrera)
                withContext(Dispatchers.Main) {
                    vista.mostrarCursos(listaCursos)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }



}