package com.example.appcursos.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appcursos.Modelo.dataCursos
import com.example.appcursos.R
import com.example.appcursos.Vista.MainActivity

class CursosAdaptador(
    private val activity: MainActivity,
    private var listaCursos: List<dataCursos>
) : RecyclerView.Adapter<CursosAdaptador.CursosViewHolder>() {

    class CursosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCurso: ImageView = itemView.findViewById(R.id.imgCurso)
        val txtCurso: TextView = itemView.findViewById(R.id.txtCurso)
        val txtSalon: TextView = itemView.findViewById(R.id.txtSalon)
        val btnVerDetalle: Button = itemView.findViewById(R.id.btnVerDetalle)
        val btnRegistrarse: Button = itemView.findViewById(R.id.btnRegistrarse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cursos, parent, false)
        return CursosViewHolder(view)
    }

    override fun onBindViewHolder(holder: CursosViewHolder, position: Int) {
        val curso = listaCursos[position]

        holder.txtCurso.text = curso.nombrecurso
        holder.txtSalon.text = "Salón: ${curso.salon}"
        val baseurl="https://apicursos.4cuthh.com/cursos_api/"
        val urlImagenCompleta=baseurl+curso.urlimagenprincipal
            Glide.with(holder.itemView.context)
                .load(urlImagenCompleta)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.imgCurso)


        holder.btnVerDetalle.setOnClickListener {
            //Para mi compañerito javier
            activity.seleccionarCurso(curso)

        }

        holder.btnRegistrarse.setOnClickListener {
            // para mi compañero Geras
            activity.registrarseCurso(curso)
        }
    }

    override fun getItemCount(): Int = listaCursos.size

    fun actualizarLista(nuevaLista: List<dataCursos>) {
        listaCursos = nuevaLista
        notifyDataSetChanged()
    }
}