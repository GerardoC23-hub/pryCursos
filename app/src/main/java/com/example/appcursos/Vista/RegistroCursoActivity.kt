package com.example.appcursos.Vista

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.appcursos.Presentador.clsInscripcionPresentador
import com.example.appcursos.R
import java.util.Calendar

class RegistroCursoActivity : AppCompatActivity() {
    private lateinit var txtNombre: TextView
    private lateinit var txtCurso: TextView
    private lateinit var imgCurso: ImageView

    private lateinit var txtMatricula: EditText
    private lateinit var txtFecha: EditText
    private lateinit var txtCorreoInstitucional: EditText
    private lateinit var presenter: clsInscripcionPresentador

    private lateinit var btnCancelar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_curso)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtNombre = findViewById(R.id.txtCursoI)
        txtCurso = findViewById(R.id.txtCursoR)
        imgCurso = findViewById(R.id.imgCursoR)
        txtMatricula = findViewById(R.id.txtMatricula)
        txtFecha = findViewById(R.id.txtFecha)
        txtCorreoInstitucional = findViewById(R.id.txtCorreoInstitucional)

        btnCancelar = findViewById(R.id.btnCancelar)
        val nombreCurso = intent.getStringExtra("NOMBRE_CURSO")?:""
        val urlImagen = intent.getStringExtra("URL_IMAGEN")?:""

        txtNombre.text = nombreCurso
        txtCurso.text = nombreCurso
        presenter = clsInscripcionPresentador(this)

        val baseUrl = "https://apicursos.4cuthh.com/cursos_api/"
        Glide.with(this)
            .load(baseUrl + urlImagen)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.stat_notify_error)
            .into(imgCurso)

        txtMatricula.setOnEditorActionListener(this::ejecutarBuscarAlumno)
        txtFecha.setOnClickListener(this::ejecutarSeleccionarFecha)
        btnCancelar.setOnClickListener(this::ejecutarCancelar)
    }

    fun ejecutarBuscarAlumno(v: TextView?, actionId: Int, event: KeyEvent?): Boolean
    {
        if (actionId == EditorInfo.IME_ACTION_SEARCH)
        {
            val matricula = txtMatricula.text.toString().trim()
            presenter.buscarAlumno(matricula)
            return true
        }
        return false
    }

    fun ejecutarCancelar(v: View)
    {
        finish()
    }

    fun insertarCorreo(correo: String)
    {
        txtCorreoInstitucional.setText(correo)
    }

    fun limpiarCorreo()
    {
        txtCorreoInstitucional.setText("")
    }

    fun mostrarMensaje(mensaje: String)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

    fun mostrarError(mensaje: String)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }

    fun ejecutarSeleccionarFecha(v: View)
    {
        val hoy = Calendar.getInstance()
        val year = hoy.get(Calendar.YEAR)
        val month = hoy.get(Calendar.MONTH)
        val day = hoy.get(Calendar.DAY_OF_MONTH)

        val dialogo = DatePickerDialog(this, { _, yearElegido, monthElegido, dayElegido ->
            txtFecha.setText(
                String.format(
                    "%04d-%02d-%02d",
                    yearElegido,
                    monthElegido + 1,
                    dayElegido
                )
            )
        }, year, month, day)
        dialogo.show()
    }
}