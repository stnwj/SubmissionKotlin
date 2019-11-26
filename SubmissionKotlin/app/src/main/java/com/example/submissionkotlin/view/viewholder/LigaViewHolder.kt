package com.example.submissionkotlin.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionkotlin.R
import com.example.submissionkotlin.model.LigaModel
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.find

class LigaViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    fun bind(ligas: LigaModel, clicklistener:(LigaModel) -> Unit) {
        val nama = itemView.find<TextView>(R.id.lblNama)
        val deskripsi = itemView.find<TextView>(R.id.cvDeskripsi)
        val gambar = itemView.find<ImageView>(R.id.imgLiga)

        nama.text = ligas.nama
        deskripsi.text = ligas.deskripsi
        Glide.with(itemView.context).load(ligas.image).apply(RequestOptions.circleCropTransform()).into(gambar)

        itemView.setOnClickListener{
            clicklistener(ligas)
        }
    }
}