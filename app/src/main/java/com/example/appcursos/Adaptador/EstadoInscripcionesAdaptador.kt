package com.example.appcursos.Adaptador

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appcursos.Modelo.dataEstadoInscripciones
import com.example.appcursos.R
import com.example.appcursos.Vista.EstadoRegistroActivity
import com.example.appcursos.Vista.RegistroCursoActivity

class EstadoInscripcionesAdaptador(private val activity: EstadoRegistroActivity,private var listaInscripciones: List<dataEstadoInscripciones>):
    RecyclerView.Adapter<EstadoInscripcionesAdaptador.EstadoInscripcionesViewHolder>(){


    class EstadoInscripcionesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val txtNombre: TextView = itemView.findViewById(R.id.txtNombreCurso)
        val txtInscritos: TextView = itemView.findViewById(R.id.txtInscritos)
        val progressBararraCurso: ProgressBar = itemView.findViewById(R.id.progressBarCurso)
        val txtTotalInscritos: TextView = itemView.findViewById(R.id.txtTotalCurso)
        val imgCurso: ImageView = itemView.findViewById(R.id.imgCursoEstado)

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EstadoInscripcionesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cursos_registro,parent,false)
        return EstadoInscripcionesViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: EstadoInscripcionesViewHolder,
        position: Int
    ) {
        val inscritos = listaInscripciones[position]
        holder.txtNombre.text = inscritos.nombrecurso
        holder.progressBararraCurso.max = inscritos.cupomaximo
        holder.progressBararraCurso.progress = inscritos.inscritos
        holder.txtInscritos.text = inscritos.inscritos.toString()+"Inscritos"
        holder.txtTotalInscritos.text = inscritos.cupomaximo.toString()+"Total"

        val baseUrl= "https://apicursos.4cuthh.com/cursos_api/"
        val urlImagenesCurso =baseUrl + inscritos.urlimagenprincipal
        val color = if(inscritos.cupomaximo >0 && inscritos.inscritos >= inscritos.cupomaximo)R.color.verde_registro else R.color.primary_color
        holder.progressBararraCurso.progressTintList = ColorStateList.valueOf(ContextCompat.getColor(holder.itemView.context, color))
        Glide.with(holder.itemView.context)
            .load(urlImagenesCurso)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.imgCurso)


    }
    override fun getItemCount(): Int {
        return listaInscripciones.size
    }
    fun actualizarLista(nuevaLista: List<dataEstadoInscripciones>)
    {
        listaInscripciones = nuevaLista
        notifyDataSetChanged()
    }


}