package com.example.submissionkotlin2.controller

import com.example.submissionkotlin2.BuildConfig
import com.example.submissionkotlin2.model.DetailLigaModel
import com.example.submissionkotlin2.model.DetailMatchesModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.submissionkotlin2.model.DetailTimModel
import com.example.submissionkotlin2.model.MatchesModel
import com.example.submissionkotlin2.view.callback.*


class LigaController {


    lateinit var jsonObject: JSONObject
    lateinit var jsonArray: JSONArray

    fun getAPI(): RetrofitCallback {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RetrofitCallback::class.java)
    }

    fun getDetailLiga(id: String, detailLigaCallBack: DetailLigaCallBack) {
        val responseBodyCall = getAPI().getDetailLiga(id)
        responseBodyCall.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val responses = response.body()!!.string()
                jsonObject = JSONObject(responses)
                jsonArray = JSONArray(jsonObject.getString("leagues"))
                jsonObject = jsonArray.getJSONObject(0)

                val detailLigaModel = DetailLigaModel(
                    jsonObject.getString("idLeague"),
                    jsonObject.getString("strLeague"),
                    jsonObject.getString("strDescriptionEN"),
                    jsonObject.getString("dateFirstEvent"),
                    jsonObject.getString("strGender"),
                    jsonObject.getString("strWebsite"),
                    jsonObject.getString("strBadge"),
                    jsonObject.getString("strFanart1")
                )
                detailLigaCallBack.onDetailLiga(detailLigaModel)
            }
        })
    }

    fun getPreviousMatches(id: String, matchesCallBack: MatchesCallBack) {
        val responseBodyCall = getAPI().getPastMatch(id)
        responseBodyCall.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val responses = response.body()!!.string()
                jsonObject = JSONObject(responses)
                jsonArray = JSONArray(jsonObject.getString("events"))

                for (i in 0 until jsonArray.length()) {

                    jsonObject = jsonArray.getJSONObject(i)
                    val idmatch = jsonObject.getString("idEvent")
                    val title = jsonObject.getString("strEvent")
                    val date = jsonObject.getString("dateEvent")
                    val scorehometeam = jsonObject.getString("intHomeScore")
                    val scoreawayteam = jsonObject.getString("intAwayScore")
                    val idhometeam = jsonObject.getString("idHomeTeam")
                    val idawayteam = jsonObject.getString("idAwayTeam")
                    val titlehome = jsonObject.getString("strHomeTeam")
                    val titleaway = jsonObject.getString("strAwayTeam")
                    getImageTim(idhometeam, object : ImageTimCallBack {
                        override fun getImageTim(detailTimModel: DetailTimModel) {
                            val imghometeam = detailTimModel.imgTim
                            getImageTim(idawayteam, object : ImageTimCallBack {
                                override fun getImageTim(detailTimModel: DetailTimModel) {
                                    val imgawayteam = detailTimModel.imgTim
                                    val matchesModel = MatchesModel(
                                        idmatch,
                                        title,
                                        date,
                                        scorehometeam,
                                        scoreawayteam,
                                        titlehome,
                                        titleaway,
                                        imghometeam,
                                        imgawayteam
                                    )

                                    matchesCallBack.onMatchesCallBack(matchesModel)
                                }

                            })
                        }
                    })
                }
            }
        })
    }

    fun getNextMatches(id: String, matchesCallBack: MatchesCallBack) {
        val responseBodyCall = getAPI().getNextMatch(id)
        responseBodyCall.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val responses = response.body()!!.string()
                jsonObject = JSONObject(responses)
                jsonArray = JSONArray(jsonObject.getString("events"))

                for (i in 0 until jsonArray.length()) {

                    jsonObject = jsonArray.getJSONObject(i)
                    val idmatch = jsonObject.getString("idEvent")
                    val title = jsonObject.getString("strEvent")
                    val date = jsonObject.getString("dateEvent")
                    val idhometeam = jsonObject.getString("idHomeTeam")
                    val idawayteam = jsonObject.getString("idAwayTeam")
                    val titlehome = jsonObject.getString("strHomeTeam")
                    val titleaway = jsonObject.getString("strAwayTeam")
                    getImageTim(idhometeam, object : ImageTimCallBack {
                        override fun getImageTim(detailTimModel: DetailTimModel) {
                            val imghometeam = detailTimModel.imgTim
                            getImageTim(idawayteam, object : ImageTimCallBack {
                                override fun getImageTim(detailTimModel: DetailTimModel) {
                                    val imgawayteam = detailTimModel.imgTim
                                    val matchesModel = MatchesModel(
                                        idmatch,
                                        title,
                                        date,
                                        "-",
                                        "-",
                                        titlehome,
                                        titleaway,
                                        imghometeam,
                                        imgawayteam
                                    )

                                    matchesCallBack.onMatchesCallBack(matchesModel)
                                }

                            })
                        }

                    })
                }
            }
        })
    }

    fun getDetailMatches(id: String, detailMatchesCallBack: DetailMatchesCallBack) {
        val responseBodyCall = getAPI().getDetailMatch(id)
        responseBodyCall.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val responses = response.body()!!.string()
                jsonObject = JSONObject(responses)
                jsonArray = JSONArray(jsonObject.getString("events"))

                jsonObject = jsonArray.getJSONObject(0)
                val idmatch = jsonObject.getString("idEvent")
                val title = jsonObject.getString("strEvent")
                val date = jsonObject.getString("dateEvent")
                val scorehometeam = jsonObject.getString("intHomeScore")
                val scoreawayteam = jsonObject.getString("intAwayScore")
                val idhometeam = jsonObject.getString("idHomeTeam")
                val idawayteam = jsonObject.getString("idAwayTeam")
                val titlehome = jsonObject.getString("strHomeTeam")
                val titleaway = jsonObject.getString("strAwayTeam")
                val yellowcardhome = jsonObject.getString("strHomeYellowCards")
                val yellowcardaway = jsonObject.getString("strAwayYellowCards")
                val redcardhome = jsonObject.getString("strHomeRedCards")
                val redcardaway = jsonObject.getString("strAwayRedCards")
                val goalkeeperhome = jsonObject.getString("strHomeLineupGoalkeeper")
                val goalkeeperaway = jsonObject.getString("strAwayLineupGoalkeeper")
                val dfhome = jsonObject.getString("strHomeLineupDefense")
                val dfaway = jsonObject.getString("strAwayLineupDefense")
                val mdhome = jsonObject.getString("strHomeLineupMidfield")
                val mdaway = jsonObject.getString("strAwayLineupMidfield")
                val ffhome = jsonObject.getString("strHomeLineupForward")
                val ffaway = jsonObject.getString("strAwayLineupForward")
                val subshome = jsonObject.getString("strHomeLineupSubstitutes")
                val subsaway = jsonObject.getString("strAwayLineupSubstitutes")
                val goaldethome = jsonObject.getString("strHomeGoalDetails")
                val goaldetaway = jsonObject.getString("strAwayGoalDetails")

                getImageTim(idhometeam, object : ImageTimCallBack {
                    override fun getImageTim(detailTimModel: DetailTimModel) {
                        val imghometeam = detailTimModel.imgTim
                        getImageTim(idawayteam, object : ImageTimCallBack {
                            override fun getImageTim(detailTimModel: DetailTimModel) {
                                val imgawayteam = detailTimModel.imgTim

                                val detailMatchesModel = DetailMatchesModel(
                                    idmatch,
                                    title,
                                    date,
                                    scorehometeam,
                                    scoreawayteam,
                                    titlehome,
                                    titleaway,
                                    yellowcardhome,
                                    yellowcardaway,
                                    redcardhome,
                                    redcardaway,
                                    goalkeeperhome,
                                    goalkeeperaway,
                                    dfhome,
                                    dfaway,
                                    mdhome,
                                    mdaway,
                                    ffhome,
                                    ffaway,
                                    subshome,
                                    subsaway,
                                    imghometeam,
                                    imgawayteam,
                                    goaldethome,
                                    goaldetaway
                                )
                                detailMatchesCallBack.onDetailMatch(detailMatchesModel)
                            }

                        })
                    }

                })

            }
        })
    }

    fun searchTim(query: String, matchesCallBack: MatchesCallBack) {
        val responseBodyCall = getAPI().searchTim(query)
        responseBodyCall.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val responses = response.body()!!.string()
                jsonObject = JSONObject(responses)
                jsonArray = JSONArray(jsonObject.getString("event"))

                for (i in 0 until jsonArray.length()) {

                    jsonObject = jsonArray.getJSONObject(i)
                    val idmatch = jsonObject.getString("idEvent")
                    val title = jsonObject.getString("strEvent")
                    val date = jsonObject.getString("dateEvent")
                    val scorehometeam = jsonObject.getString("intHomeScore")
                    val scoreawayteam = jsonObject.getString("intAwayScore")
                    val idhometeam = jsonObject.getString("idHomeTeam")
                    val idawayteam = jsonObject.getString("idAwayTeam")
                    val titlehome = jsonObject.getString("strHomeTeam")
                    val titleaway = jsonObject.getString("strAwayTeam")
                    getImageTim(idhometeam, object : ImageTimCallBack {
                        override fun getImageTim(detailTimModel: DetailTimModel) {
                            val imghometeam = detailTimModel.imgTim
                            getImageTim(idawayteam, object : ImageTimCallBack {
                                override fun getImageTim(detailTimModel: DetailTimModel) {
                                    val imgawayteam = detailTimModel.imgTim
                                    val matchesModel = MatchesModel(
                                        idmatch,
                                        title,
                                        date,
                                        scorehometeam,
                                        scoreawayteam,
                                        titlehome,
                                        titleaway,
                                        imghometeam,
                                        imgawayteam
                                    )

                                    matchesCallBack.onMatchesCallBack(matchesModel)
                                }

                            })
                        }

                    })
                }
            }
        })
    }

    fun getImageTim(id: String, imageTimCallBack: ImageTimCallBack) {
        val responseBodyCall = getAPI().getDetailTim(id)
        responseBodyCall.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val responses = response.body()!!.string()
                jsonObject = JSONObject(responses)
                jsonArray = JSONArray(jsonObject.getString("teams"))
                jsonObject = jsonArray.getJSONObject(0)
                val detailTimModel = DetailTimModel(jsonObject.getString("strTeamBadge"))
                imageTimCallBack.getImageTim(detailTimModel)
            }
        })
    }

}