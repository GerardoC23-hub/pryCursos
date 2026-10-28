package com.example.appcursos.Vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcursos.Adaptador.EstadoInscripcionesAdaptador
import com.example.appcursos.Modelo.dataCarreras
import com.example.appcursos.Modelo.dataEstadoInscripciones
import com.example.appcursos.Presentador.clsEstadoInscripcionPresentador
import com.example.appcursos.R

class EstadoRegistroActivity : AppCompatActivity() {
    private lateinit var presentador: clsEstadoInscripcionPresentador
    private lateinit var spinnerCarreras: Spinner
    private lateinit var recyclerInscripciones: RecyclerView
    private lateinit var adapterEstadoInscripciones: EstadoInscripcionesAdaptador
    private lateinit var btnVoler: Button
    private var listaCarreras: List<dataCarreras> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estado_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        spinnerCarreras = findViewById(R.id.spnCarrerasInscripciones)
        recyclerInscripciones = findViewById(R.id.rvInscripciones)
        btnVoler = findViewById(R.id.btnVolverCatalogo)

        recyclerInscripciones.layoutManager = LinearLayoutManager(this)
        adapterEstadoInscripciones = EstadoInscripcionesAdaptador(this, emptyList())
        recyclerInscripciones.adapter = adapterEstadoInscripciones
        presentador = clsEstadoInscripcionPresentador(this)

        configurarListeners()
        presentador.iniciar()
        btnVoler.setOnClickListener(this::mostrarVolver)

    }
    private fun configurarListeners()
    {
        spinnerCarreras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                presentador.seleccionarCarrera(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
    fun mostrarVolver(v: View){
        presentador.volver()
    }
    fun mostrarCarreras(carreras: List<dataCarreras>) {
        listaCarreras = carreras
        val nombresCarreras = mutableListOf("Todas las carreras")
        nombresCarreras.addAll(carreras.map { it.carrera })

        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            nombresCarreras
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCarreras.adapter = spinnerAdapter

        spinnerCarreras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {
                    presentador.obtenerCursosPorCarrera(0)
                } else {
                    val idCarrera = listaCarreras[position - 1].id
                    presentador.obtenerCursosPorCarrera(idCarrera)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
    fun mostrarCursos(cursos: List<dataEstadoInscripciones>)
    {
        adapterEstadoInscripciones.actualizarLista(cursos)
    }
    fun mostrarError(mensaje:String)
    {
        Toast.makeText(this,mensaje, Toast.LENGTH_LONG).show()
    }
    fun abrirCatalogoCursos()
    {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
    }
}