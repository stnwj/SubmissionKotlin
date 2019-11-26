package com.example.submissionkotlin2.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionkotlin2.R
import com.example.submissionkotlin2.model.LigaModel
import com.example.submissionkotlin2.view.activity.DetailLigaActivity
import com.example.submissionkotlin2.view.viewholder.LigaViewHolder

class LigaAdapter(val context: Context, val ligaList: ArrayList<LigaModel>) :
    RecyclerView.Adapter<LigaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LigaViewHolder =
        LigaViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_liga, parent, false
            )
        )

    override fun getItemCount(): Int = ligaList.size

    override fun onBindViewHolder(holder: LigaViewHolder, position: Int) {
        holder.lblJudul.text = ligaList[position].name
        holder.lblDeskripsi.text = ligaList[position].deskripsi
        Glide.with(context)
            .load(ligaList[position].image)
            .into(holder.imgLiga)
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(context,DetailLigaActivity::class.java)
            intent.putExtra("idliga", ligaList[position].id)
            context.startActivity(intent)
        }
    }
}