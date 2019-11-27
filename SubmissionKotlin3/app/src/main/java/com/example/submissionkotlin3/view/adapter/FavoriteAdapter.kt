package com.example.submissionkotlin3.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionkotlin3.R
import com.example.submissionkotlin3.model.Favorite
import com.example.submissionkotlin3.view.activity.DetailMatchesActivity
import com.example.submissionkotlin3.view.viewholder.MatchesViewHolder

class FavoriteAdapter(val context: Context, val matchesArrayList:ArrayList<Favorite>): RecyclerView.Adapter<MatchesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder =
        MatchesViewHolder(LayoutInflater.from(context).inflate(R.layout.list_pertandingan,parent, false))

    override fun getItemCount(): Int = matchesArrayList.size

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        holder.lblTitle.text = matchesArrayList.get(position).namaEvent
        holder.lblTime.text = matchesArrayList.get(position).dateEvent
        holder.lblScoreHome.text = matchesArrayList.get(position).scoreHome
        holder.lblScoreAway.text = matchesArrayList.get(position).scoreAway
        holder.lblTitleHome.text = matchesArrayList.get(position).homeEvent
        holder.lblTitleAway.text = matchesArrayList.get(position).awayEvent
        Glide.with(context)
            .load(matchesArrayList.get(position).imgHome)
            .into(holder.imgHomeTeam)
        Glide.with(context)
            .load(matchesArrayList.get(position).imgAway)
            .into(holder.imgAwayTeam)
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(context, DetailMatchesActivity::class.java)
            intent.putExtra("idmatch", matchesArrayList.get(position).idEvent)
            context.startActivity(intent)
        }
    }
}