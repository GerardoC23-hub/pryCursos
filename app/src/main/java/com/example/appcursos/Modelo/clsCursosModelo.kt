package com.example.appcursos.Modelo

class clsCursosModelo {

    suspend fun obtenerDetalleCurso(idCurso: Int):List<dataImagenesCurso>
    {
        return RetrofitCliente.apiService.detalleCurso(idCurso)
    }
}