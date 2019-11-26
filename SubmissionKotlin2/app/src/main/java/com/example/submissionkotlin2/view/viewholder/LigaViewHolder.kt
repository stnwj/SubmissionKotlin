package com.example.submissionkotlin2.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_liga.view.*

class LigaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lblJudul = itemView.lblJudul
        val lblDeskripsi  = itemView.lblDeskripsi
        val imgLiga = itemView.imgLiga
}