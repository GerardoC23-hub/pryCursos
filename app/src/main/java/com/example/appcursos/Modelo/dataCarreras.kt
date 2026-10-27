package com.example.appcursos.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataCarreras(
    @SerialName("id") val id: Int = 0,
    @SerialName("carrera") val carrera: String = ""
)
