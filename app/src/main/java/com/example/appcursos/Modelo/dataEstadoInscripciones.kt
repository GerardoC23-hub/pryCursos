package com.example.appcursos.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataEstadoInscripciones(
    @SerialName("id")val id:Int=0,
    @SerialName("id_carrera")val idcarrera:Int=0,
    @SerialName("nombre_curso")val nombrecurso: String="",
    @SerialName("url_imagen_principal")val urlimagenprincipal:String="",
    @SerialName("cupo_maximo")val cupomaximo:Int=0,
    @SerialName("inscritos")val inscritos:Int=0

    )
