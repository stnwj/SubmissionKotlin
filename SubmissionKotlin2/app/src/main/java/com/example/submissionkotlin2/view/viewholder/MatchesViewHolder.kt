package com.example.submissionkotlin2.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_pertandingan.view.*

class MatchesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val lblTitle = itemView.lblTitle
    val lblTime = itemView.lblDate
    val lblTitleHome = itemView.lblTitleHome
    val lblTitleAway = itemView.lblTitleAway
    val lblScoreHome = itemView.lblScoreHome
    val lblScoreAway = itemView.lblScoreAway
    val imgHomeTeam = itemView.imgHomeTeam
    val imgAwayTeam = itemView.imgAwayTeam
}