package com.example.appcursos.Presentador

import com.example.appcursos.Modelo.clsCarrerasModelo
import com.example.appcursos.Modelo.clsCursosModelo
import com.example.appcursos.Modelo.dataCursos
import com.example.appcursos.Vista.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class clsCarrerasPresentador(private val vista: MainActivity) {
    private val carrerasModelo = clsCarrerasModelo()
    private val cursosModelo = clsCursosModelo()

    fun obtenerCarreras() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val listaCarreras = carrerasModelo.obtenerCarreras()
                withContext(Dispatchers.Main) {
                    vista.mostrarCarreras(listaCarreras)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }



    fun obtenerCursosPorCarrera(idCarrera: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val listaCursos = cursosModelo.ObtenerCursosPorCarrera(idCarrera)
                withContext(Dispatchers.Main) {
                    vista.mostrarCursos(listaCursos)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun seleccionarCurso(curso: dataCursos)
    {
        vista.DetalleCurso(curso.id,curso.codigocurso,curso.nombrecurso,curso.descripcion,curso.edificio,curso.salon,curso.totalhoras,curso.diasatencion,curso.horasatencion)
    }


    fun inscripcionCurso(curso: dataCursos)
    {
        vista.abrirInscripcionCurso(curso.id,curso.nombrecurso,curso.urlimagenprincipal)
    }
}