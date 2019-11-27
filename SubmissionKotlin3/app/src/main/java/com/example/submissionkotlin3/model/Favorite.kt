package com.example.submissionkotlin3.model

data class Favorite(
    val idauto: Long,
    val idEvent: String,
    val namaEvent: String,
    val dateEvent: String,
    val homeEvent: String,
    val awayEvent: String,
    val scoreHome: String,
    val scoreAway: String,
    val imgHome: String,
    val imgAway: String
) {

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val ID_EVENT: String = "ID_EVENT"
        const val NAMA_EVENT: String = "NAMA_EVENT"
        const val DATE_EVENT: String = "DATE_EVENT"
        const val HOME_EVENT: String = "HOME_EVENT"
        const val AWAY_EVENT: String = "AWAY_EVENT"
        const val SCORE_HOME: String = "SCORE_HOME"
        const val SCORE_AWAY: String = "SCORE_AWAY"
        const val IMG_HOME: String = "IMG_HOME"
        const val IMG_AWAY: String = "IMG_AWAY"
    }
}