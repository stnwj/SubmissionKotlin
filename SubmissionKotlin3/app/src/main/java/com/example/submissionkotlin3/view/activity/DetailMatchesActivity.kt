package com.example.submissionkotlin3.view.activity

import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.dataapi.view.dbhelper.database
import com.example.submissionkotlin3.R
import com.example.submissionkotlin3.controller.LigaController
import com.example.submissionkotlin3.model.DetailMatchesModel
import com.example.submissionkotlin3.model.Favorite
import com.example.submissionkotlin3.view.callback.DetailMatchesCallBack
import kotlinx.android.synthetic.main.activity_detail_matches.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class DetailMatchesActivity : AppCompatActivity() {

    var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_matches)
        val idmatch = intent.getStringExtra("idmatch")
        bindingData(idmatch!!)
        imgBack.setOnClickListener { finish() }
    }

    private fun bindingData(idmatch: String) {
        LigaController().getDetailMatches(idmatch, object : DetailMatchesCallBack {
            override fun onDetailMatch(detailMatchesModel: DetailMatchesModel) {
                favorites(detailMatchesModel)

                Glide.with(this@DetailMatchesActivity)
                    .load(detailMatchesModel.imghometeam)
                    .into(imgHomeTeam)
                Glide.with(this@DetailMatchesActivity)
                    .load(detailMatchesModel.imgawayteam)
                    .into(imgAwayTeam)

                if (detailMatchesModel.scorehometeam.equals("null") || detailMatchesModel.scorehometeam.equals(
                        ""
                    )
                ) {
                    lblScoreHome.text = resources.getString(R.string.strip)
                } else {
                    lblScoreHome.text = detailMatchesModel.scorehometeam
                }

                if (detailMatchesModel.scoreawayteam.equals("null") || detailMatchesModel.scoreawayteam.equals(
                        ""
                    )
                ) {
                    lblScoreAway.text = resources.getString(R.string.strip)
                } else {
                    lblScoreAway.text = detailMatchesModel.scoreawayteam
                }

                lblTitleHome.text = detailMatchesModel.titlehome
                lblTitleAway.text = detailMatchesModel.titleaway
                lblTitle.text = detailMatchesModel.title
                lblDate.text = detailMatchesModel.date

                if (detailMatchesModel.yellowcardhome.equals("null") || detailMatchesModel.yellowcardhome.equals(
                        ""
                    )
                ) {
                    lblYellowCardHome.text = resources.getString(R.string.strip)
                } else {
                    lblYellowCardHome.text = detailMatchesModel.yellowcardhome.replace(";", "\n")
                }

                if (detailMatchesModel.yellowcardaway.equals("null") || detailMatchesModel.yellowcardaway.equals(
                        ""
                    )
                ) {
                    lblYellowCardAway.text = resources.getString(R.string.strip)
                } else {
                    lblYellowCardAway.text = detailMatchesModel.yellowcardaway.replace(";", "\n")
                }


                if (detailMatchesModel.redcardhome.equals("null") || detailMatchesModel.redcardhome.equals(
                        ""
                    )
                ) {
                    lblRedCardHome.text = resources.getString(R.string.strip)
                } else {
                    lblRedCardHome.text = detailMatchesModel.redcardhome.replace(";", "\n")
                }

                if (detailMatchesModel.redcardaway.equals("null") || detailMatchesModel.redcardaway.equals(
                        ""
                    )
                ) {
                    lblRedCardAway.text = resources.getString(R.string.strip)
                } else {
                    lblRedCardAway.text = detailMatchesModel.redcardaway.replace(";", "\n")
                }

                if (detailMatchesModel.goalkeeperhome.equals("null") || detailMatchesModel.goalkeeperhome.equals(
                        ""
                    )
                ) {
                    lblGKHome.text = resources.getString(R.string.strip)
                } else {
                    lblGKHome.text = detailMatchesModel.goalkeeperhome.replace(";", "\n")
                }

                if (detailMatchesModel.goalkeeperaway.equals("null") || detailMatchesModel.goalkeeperaway.equals(
                        ""
                    )
                ) {
                    lblGKAway.text = resources.getString(R.string.strip)
                } else {
                    lblGKAway.text = detailMatchesModel.goalkeeperaway.replace(";", "\n")
                }

                if (detailMatchesModel.dfhome.equals("null") || detailMatchesModel.dfhome.equals("")) {
                    lblDFHome.text = resources.getString(R.string.strip)
                } else {
                    lblDFHome.text = detailMatchesModel.dfhome.replace(";", "\n")
                }

                if (detailMatchesModel.dfaway.equals("null") || detailMatchesModel.dfaway.equals("")) {
                    lblDFAway.text = resources.getString(R.string.strip)
                } else {
                    lblDFAway.text = detailMatchesModel.dfaway.replace(";", "\n")
                }

                if (detailMatchesModel.mdhome.equals("null") || detailMatchesModel.mdhome.equals("")) {
                    lblMFHome.text = resources.getString(R.string.strip)
                } else {
                    lblDFAway.text = detailMatchesModel.mdhome.replace(";", "\n")
                }

                if (detailMatchesModel.mdaway.equals("null") || detailMatchesModel.mdaway.equals("")) {
                    lblMFAway.text = resources.getString(R.string.strip)
                } else {
                    lblMFAway.text = detailMatchesModel.mdaway.replace(";", "\n")
                }

                if (detailMatchesModel.ffhome.equals("null") || detailMatchesModel.ffhome.equals("")) {
                    lblFFHome.text = resources.getString(R.string.strip)
                } else {
                    lblFFHome.text = detailMatchesModel.ffhome.replace(";", "\n")
                }

                if (detailMatchesModel.ffaway.equals("null") || detailMatchesModel.ffaway.equals("")) {
                    lblFFAway.text = resources.getString(R.string.strip)
                } else {
                    lblFFAway.text = detailMatchesModel.ffaway.replace(";", "\n")
                }

                if (detailMatchesModel.subshome.equals("null") || detailMatchesModel.subshome.equals(
                        ""
                    )
                ) {
                    lblSubsHome.text = resources.getString(R.string.strip)
                } else {
                    lblSubsHome.text = detailMatchesModel.subshome.replace(";", "\n")
                }

                if (detailMatchesModel.subsaway.equals("null") || detailMatchesModel.subsaway.equals(
                        ""
                    )
                ) {
                    lblSubsAway.text = resources.getString(R.string.strip)
                } else {
                    lblSubsAway.text = detailMatchesModel.subsaway.replace(";", "\n")
                }

                if (detailMatchesModel.goaldethome.equals("null") || detailMatchesModel.goaldethome.equals(
                        ""
                    )
                ) {
                    lblGoalDetHome.text = resources.getString(R.string.strip)
                } else {
                    lblGoalDetHome.text = detailMatchesModel.goaldethome.replace(";", "\n")
                }

                if (detailMatchesModel.goaldetaway.equals("null") || detailMatchesModel.goaldetaway.equals(
                        ""
                    )
                ) {
                    lblGoalDetAway.text = resources.getString(R.string.strip)
                } else {
                    lblGoalDetAway.text = detailMatchesModel.goaldetaway.replace(";", "\n")
                }

                detailMatchProgressbar.visibility = View.GONE

            }

        })
    }

    fun favorites(detailMatchesModel: DetailMatchesModel) {
        checkFavorite(detailMatchesModel)

        imgFavorite.setOnClickListener {
            if (isFavorite) {
                removeFavoriteSQL(detailMatchesModel)
                changeImage()
            } else {
                addFavoriteSQL(detailMatchesModel)
                changeImage()
            }
        }
    }

    fun checkFavorite(detailMatchesModel: DetailMatchesModel){
        database.use {
            val result = select(Favorite.TABLE_FAVORITE)
                .whereArgs("(ID_EVENT = {id})",
                    "id" to detailMatchesModel.idmatch)
            val favorite = result.parseList(classParser<Favorite>())
            if (!favorite.isEmpty()) {
                isFavorite = true
                changeImage()
            }

        }
    }

    fun changeImage(){
        if (isFavorite){
            imgFavorite.setBackgroundResource(R.drawable.ic_favorite__fill)
        } else{
            imgFavorite.setBackgroundResource(R.drawable.ic_favorite)
        }
    }

    fun addFavoriteSQL(detailMatchesModel: DetailMatchesModel) {
        val scorehome: String
        val scoreaway: String
        try {
            if (detailMatchesModel.scorehometeam.equals("null") || detailMatchesModel.scorehometeam.equals("")) {
                scorehome = resources.getString(R.string.strip)
            } else {
                scorehome = detailMatchesModel.scorehometeam
            }

            if (detailMatchesModel.scoreawayteam.equals("null") || detailMatchesModel.scoreawayteam.equals("")) {
                scoreaway = resources.getString(R.string.strip)
            } else {
                scoreaway = detailMatchesModel.scoreawayteam
            }
            database.use {
                insert(
                    Favorite.TABLE_FAVORITE,
                    Favorite.ID_EVENT to detailMatchesModel.idmatch,
                    Favorite.NAMA_EVENT to detailMatchesModel.title,
                    Favorite.DATE_EVENT to detailMatchesModel.date,
                    Favorite.HOME_EVENT to detailMatchesModel.titlehome,
                    Favorite.AWAY_EVENT to detailMatchesModel.titleaway,
                    Favorite.SCORE_HOME to scorehome,
                    Favorite.SCORE_AWAY to scoreaway,
                    Favorite.IMG_HOME to detailMatchesModel.imghometeam,
                    Favorite.IMG_AWAY to detailMatchesModel.imgawayteam
                )
            }
            isFavorite = true
            Toast.makeText(this, "Favorite Add", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException) {
            Toast.makeText(this, "Error Add", Toast.LENGTH_SHORT).show()
            e.stackTrace
        }
    }

    fun removeFavoriteSQL(detailMatchesModel: DetailMatchesModel){
        try {
            database.use {
                delete(Favorite.TABLE_FAVORITE, "(ID_EVENT = {id})",
                    "id" to detailMatchesModel.idmatch)
            }

            isFavorite = false
            Toast.makeText(this, "Favorite Remove", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException){
            Toast.makeText(this, "Favorite Remove", Toast.LENGTH_SHORT).show()
            e.stackTrace
        }
    }
}
