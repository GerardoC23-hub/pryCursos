package com.example.appcursos.Presentador

import com.example.appcursos.Modelo.clsInscripcionModelo
import com.example.appcursos.Vista.RegistroCursoActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class clsInscripcionPresentador(private val vista: RegistroCursoActivity) {
    private val modelo = clsInscripcionModelo()

    fun buscarAlumno(matricula: String)
    {
        if (matricula.isEmpty())
        {
            vista.limpiar()
            vista.mostrarMensaje("La matrícula es obligatoria")
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val alumno = modelo.buscarAlumno(matricula)
                if (alumno.exito)
                {
                    vista.insertarFecha(obtenerFechaHoy())
                    vista.insertarCorreo(alumno.correoinstitucional)
                    vista.mostrarMensaje(alumno.mensaje)
                }
                else
                {
                    vista.limpiar()
                    vista.mostrarError(alumno.mensaje)
                }
            } catch (e: Exception)
            {
                vista.limpiar()
                vista.mostrarError("Error al buscar alumno: " + e.localizedMessage)
            }
        }
    }

    fun registrar(idCurso: Int, matricula: String, fecha: String)
    {

        if (matricula.isEmpty())
        {
            vista.mostrarError("Escribe la matrícula")
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val respuesta = modelo.insertarInscripcion(idCurso, matricula, fecha)
                vista.registroExitoso(respuesta.mensaje)
            } catch (e: Exception)
            {
                vista.mostrarError("No se pudo registrar la inscripción: " + e.localizedMessage)
            }
        }
    }

    private fun obtenerFechaHoy(): String
    {
        return SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())
    }
}