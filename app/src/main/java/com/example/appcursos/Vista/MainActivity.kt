package com.example.appcursos.Vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcursos.Adaptador.CursosAdaptador
import com.example.appcursos.Modelo.dataCarreras
import com.example.appcursos.Modelo.dataCursos
import com.example.appcursos.Presentador.clsCarrerasPresentador
import com.example.appcursos.R

class MainActivity : AppCompatActivity() {

    private lateinit var spnCarreras: Spinner
    private lateinit var rvListaCursos: RecyclerView
    private lateinit var btnVerRegistros: Button
    private lateinit var adaptador: CursosAdaptador
    private lateinit var presentador: clsCarrerasPresentador
    private var listaCarreras: List<dataCarreras> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spnCarreras = findViewById(R.id.spnCarreras)
        rvListaCursos = findViewById(R.id.rvListaCursos)
        btnVerRegistros = findViewById(R.id.btnVerRegistros)

        rvListaCursos.layoutManager = GridLayoutManager(this,2)
        adaptador = CursosAdaptador(this, emptyList())
        rvListaCursos.adapter = adaptador

        presentador = clsCarrerasPresentador(this)

        presentador.obtenerCarreras()

        btnVerRegistros.setOnClickListener {
            val intent = Intent(this, EstadoRegistroActivity::class.java)
            startActivity(intent)
        }
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
        spnCarreras.adapter = spinnerAdapter

        spnCarreras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

    fun registrarseCurso(curso: dataCursos)
    {
        presentador.inscripcionCurso(curso)
    }

    fun abrirInscripcionCurso(id:Int, nombreCurso: String,urlImagen: String)
    {
        val intent = Intent(this, RegistroCursoActivity::class.java)
        intent.putExtra("ID_CURSO",id)
        intent.putExtra("NOMBRE_CURSO",nombreCurso)
        intent.putExtra("URL_IMAGEN",urlImagen)
        startActivity(intent)
    }

    fun mostrarCursos(cursos: List<dataCursos>) {
        adaptador.actualizarLista(cursos)
    }
}