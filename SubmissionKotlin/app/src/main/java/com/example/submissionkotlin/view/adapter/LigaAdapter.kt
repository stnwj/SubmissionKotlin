package com.example.submissionkotlin.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionkotlin.model.LigaModel
import com.example.submissionkotlin.view.layouting.UILigaList
import com.example.submissionkotlin.view.viewholder.LigaViewHolder
import org.jetbrains.anko.*

class LigaAdapter(val ligaArrayList: ArrayList<LigaModel>, val clicklistener: (LigaModel) -> Unit) :
    RecyclerView.Adapter<LigaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LigaViewHolder {
        return LigaViewHolder(UILigaList().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = ligaArrayList.size

    override fun onBindViewHolder(holder: LigaViewHolder, position: Int) {
        holder.bind(ligaArrayList[position], clicklistener)
    }


}