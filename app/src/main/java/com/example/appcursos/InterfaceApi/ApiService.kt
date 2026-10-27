package com.example.appcursos.InterfaceApi

import com.example.appcursos.Modelo.dataAlumno
import com.example.appcursos.Modelo.dataCarreras
import com.example.appcursos.Modelo.dataCursos
import com.example.appcursos.Modelo.dataEstadoInscripciones
import com.example.appcursos.Modelo.dataImagenesCurso
import com.example.appcursos.Modelo.dataInsertarRegistro
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {


    @GET("detalle_curso.php")
    suspend fun detalleCurso(@Query("id_curso")idCurso:Int):List<dataImagenesCurso>

    @GET("obtener_inscripciones.php")
    suspend fun obtenerInscripciones(@Query("id_carrera")idCarrera:Int): List<dataEstadoInscripciones>

    @GET("obtener_carreras.php")
    suspend fun obtenerCarreras(): List<dataCarreras>

    @GET("obtener_cursos.php")
    suspend fun obtenerCursos(@Query("id_carrera")idCarrera: Int): List<dataCursos>

    @GET("busqueda_alumno.php")
    suspend fun obtenerAlumno(@Query("matricula") matricula: String): dataAlumno

    @FormUrlEncoded
    @POST("inscripcion_curso.php")
    suspend fun registrarInscripcion(
        @Field("id_curso") idCurso: Int,
        @Field("matricula") matricula: String,
        @Field("fecha_registro") fechaRegistro: String
    ): dataInsertarRegistro
}