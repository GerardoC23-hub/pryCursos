package com.example.appcursos.Modelo

import retrofit2.Retrofit

class clsEstadoInscripcionModelo {
    suspend fun obtenerInscripcionesPorCarrera(idCarreras: Int): List<dataEstadoInscripciones>
    {
        return RetrofitCliente.apiService.obtenerInscripciones(idCarreras)
    }
}