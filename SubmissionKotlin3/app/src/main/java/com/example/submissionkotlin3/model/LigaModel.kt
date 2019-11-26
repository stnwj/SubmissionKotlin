package com.example.submissionkotlin3.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LigaModel (
    val id : String,
    val name : String,
    val deskripsi : String,
    val image : Int
) : Parcelable
