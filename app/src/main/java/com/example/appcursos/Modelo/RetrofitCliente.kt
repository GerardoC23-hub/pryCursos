package com.example.appcursos.Modelo

import com.example.appcursos.InterfaceApi.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object RetrofitCliente {
    //url donde esta alogado el api
    private const val BASE_URL = "https://apicursos.4cuthh.com/cursos_api/"

    private val jsonConfig = Json{
        ignoreUnknownKeys= true
        coerceInputValues = true
        isLenient = true
    }

    val apiService: ApiService by lazy{
        val contenType = "aplication/json".toMediaType()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(jsonConfig.asConverterFactory(contenType))
            .build()
            .create(ApiService::class.java)

    }
}