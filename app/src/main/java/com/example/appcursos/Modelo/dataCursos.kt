package com.example.appcursos.Modelo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataCursos(
    @SerialName("id") val id:Int = 0,
    @SerialName("codigo_curso")val codigocurso:String="",
    @SerialName("nombre_curso") val nombrecurso:String="",
    @SerialName("descripcion") val descripcion:String="",
    @SerialName("edificio") val edificio:String = "",
    @SerialName("salon") val salon: String="",
    @SerialName("total_horas") val totalhoras:String="",
    @SerialName("dias_atencion") val diasatencion:String="",
    @SerialName("horas_atencion") val horasatencion:String="",
    @SerialName("url_imagen_principal") val urlimagenprincipal: String="",
    @SerialName("cupo_maximo") val cupomaximo:String = "0",
    @SerialName("id_carrera")val idcarrera:Int=0
)
