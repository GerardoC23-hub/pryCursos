package com.example.appcursos.Modelo

class clsCursosModelo {
    suspend fun ObtenerCursosPorCarrera(idCarrera: Int):List<dataCursos>
    {
        return RetrofitCliente.apiService.obtenerCursos(idCarrera)
    }

    suspend fun obtenerDetalleCurso(idCurso: Int):List<dataImagenesCurso>
    {
        return RetrofitCliente.apiService.detalleCurso(idCurso)
    }
}