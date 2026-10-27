package com.example.appcursos.Modelo

class clsCarrerasModelo {
    suspend fun obtenerCarreras(): List<dataCarreras> {
        return RetrofitCliente.apiService.obtenerCarreras()
    }
}