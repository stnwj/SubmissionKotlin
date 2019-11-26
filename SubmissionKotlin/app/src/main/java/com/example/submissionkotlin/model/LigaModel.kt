package com.example.submissionkotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LigaModel(
    val id: String?,
    val nama: String?,
    val deskripsi: String?,
    val image: Int?
): Parcelable