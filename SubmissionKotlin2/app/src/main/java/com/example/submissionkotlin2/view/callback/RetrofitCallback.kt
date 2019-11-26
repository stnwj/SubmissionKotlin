package com.example.submissionkotlin2.view.callback

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitCallback {
    @GET("lookupleague.php") // idliga
    fun getDetailLiga(@Query("id") id: String): Call<ResponseBody>

    @GET("eventsnextleague.php") // idliga
    fun getNextMatch(@Query("id") id: String): Call<ResponseBody>

    @GET("eventspastleague.php") // idliga
    fun getPastMatch(@Query("id") id: String): Call<ResponseBody>

    @GET("lookupteam.php") // idtim
    fun getDetailTim(@Query("id") id: String): Call<ResponseBody>

    @GET("lookupevent.php") // idmatch / event
    fun getDetailMatch(@Query("id") id: String): Call<ResponseBody>

    @GET("searchevents.php") // idmatch / event
    fun searchTim(@Query("e") id: String): Call<ResponseBody>

}