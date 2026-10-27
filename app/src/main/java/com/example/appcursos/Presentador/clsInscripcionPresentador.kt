package com.example.appcursos.Presentador

import com.example.appcursos.Modelo.clsInscripcionModelo
import com.example.appcursos.Vista.RegistroCursoActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsInscripcionPresentador(private val vista: RegistroCursoActivity) {
    private val modelo = clsInscripcionModelo()

    fun buscarAlumno(matricula: String)
    {
        if (matricula.isBlank())
        {
            vista.limpiarCorreo()
            vista.mostrarMensaje("La matrícula es obligatoria")
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val alumno = modelo.buscarAlumno(matricula)
                if (alumno.exito)
                {
                    vista.insertarCorreo(alumno.correoinstitucional)
                    vista.mostrarMensaje(alumno.mensaje)
                }
                else
                {
                    vista.limpiarCorreo()
                    vista.mostrarError(alumno.mensaje)
                }
            } catch (e: Exception)
            {
                vista.limpiarCorreo()
                vista.mostrarError("Error al buscar alumno: " + e.localizedMessage)
            }
        }
    }
}