package com.example.submissionkotlin2.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionkotlin2.R
import com.example.submissionkotlin2.model.MatchesModel
import com.example.submissionkotlin2.view.activity.DetailMatchesActivity
import com.example.submissionkotlin2.view.viewholder.MatchesViewHolder

class MatchesAdapter(val context: Context, val matchesArrayList:ArrayList<MatchesModel>): RecyclerView.Adapter<MatchesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder =
        MatchesViewHolder(LayoutInflater.from(context).inflate(R.layout.list_pertandingan,parent, false))

    override fun getItemCount(): Int = matchesArrayList.size

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        holder.lblTitle.text = matchesArrayList.get(position).title
        holder.lblTime.text = matchesArrayList.get(position).date

        if (matchesArrayList.get(position).scorehome.equals("null") || matchesArrayList.get(position).scorehome.equals("")){
            holder.lblScoreHome.text = context.resources.getString(R.string.strip)
        }else {
            holder.lblScoreHome.text = matchesArrayList.get(position).scorehome
        }

        if (matchesArrayList.get(position).scoreaway.equals("null") || matchesArrayList.get(position).scoreaway.equals("")){
            holder.lblScoreAway.text = context.resources.getString(R.string.strip)
        }else {
            holder.lblScoreAway.text = matchesArrayList.get(position).scoreaway
        }
        holder.lblTitleHome.text = matchesArrayList.get(position).titlehome
        holder.lblTitleAway.text = matchesArrayList.get(position).titleaway
        Glide.with(context)
            .load(matchesArrayList.get(position).imghome)
            .into(holder.imgHomeTeam)
        Glide.with(context)
            .load(matchesArrayList.get(position).imgaway)
            .into(holder.imgAwayTeam)
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(context, DetailMatchesActivity::class.java)
            intent.putExtra("idmatch", matchesArrayList.get(position).idmatch)
            context.startActivity(intent)
          }
    }
}