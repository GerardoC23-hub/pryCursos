package com.example.appcursos.Presentador

import com.example.appcursos.Modelo.clsCursosModelo
import com.example.appcursos.Modelo.dataImagenesCurso
import com.example.appcursos.Vista.DetalleCursosActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsDetalleCursoPresentador(private val vista: DetalleCursosActivity) {
    private val modelo = clsCursosModelo()

    fun cargarDetalle(idCurso:Int)
    {
        CoroutineScope(Dispatchers.Main).launch{
            try{
                val listaImagenes: List<dataImagenesCurso> = modelo.obtenerDetalleCurso(idCurso)
                vista.mostrarImagenes(listaImagenes)
            }catch (e: Exception)
            {
                vista.mostrarError("Error al cargar detalle:" + e.localizedMessage)
            }
        }
    }
}