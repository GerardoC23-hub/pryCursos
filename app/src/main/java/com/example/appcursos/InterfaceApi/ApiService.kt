package com.example.appcursos.InterfaceApi

import com.example.appcursos.Modelo.dataEstadoInscripciones
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("obtener_inscripciones.php")
    suspend fun obtenerInscripciones(@Query("id_carrera")idCarrera:Int): List<dataEstadoInscripciones>
}