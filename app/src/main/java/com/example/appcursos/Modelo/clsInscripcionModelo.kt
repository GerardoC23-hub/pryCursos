package com.example.appcursos.Modelo

class clsInscripcionModelo {
    suspend fun buscarAlumno(matricula:String):dataAlumno
    {
        return RetrofitCliente.apiService.obtenerAlumno(matricula)
    }

    suspend fun insertarInscripcion(idCurso: Int,matricula:String,fecha_registro: String):dataInsertarRegistro
    {
        return RetrofitCliente.apiService.registrarInscripcion(idCurso,matricula,fecha_registro)
    }
}