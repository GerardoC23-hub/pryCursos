package com.example.appcursos.InterfaceApi

import com.example.appcursos.Modelo.dataEstadoInscripciones
import com.example.appcursos.Modelo.dataImagenesCurso
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("detalle_curso.php")
    suspend fun detalleCurso(@Query("id_curso")idCurso:Int):List<dataImagenesCurso>

    @GET("obtener_inscripciones.php")
    suspend fun obtenerInscripciones(@Query("id_carrera")idCarrera:Int): List<dataEstadoInscripciones>
}