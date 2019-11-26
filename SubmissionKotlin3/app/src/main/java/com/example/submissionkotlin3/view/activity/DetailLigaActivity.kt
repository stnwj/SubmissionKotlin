package com.example.submissionkotlin3.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.submissionkotlin3.R
import com.example.submissionkotlin3.controller.LigaController
import com.example.submissionkotlin3.model.DetailLigaModel
import com.example.submissionkotlin3.view.adapter.MatchesFragmentPageAdapter
import com.example.submissionkotlin3.view.callback.DetailLigaCallBack
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_detail_liga.*

class DetailLigaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_liga)

        val idliga = intent.getStringExtra("idliga")

        LigaController().getDetailLiga(idliga!!, object : DetailLigaCallBack {
            override fun onDetailLiga(detailLigaModel: DetailLigaModel) {
                Glide.with(this@DetailLigaActivity)
                    .load(detailLigaModel.gambar)
                    .into(imgLiga)
                Glide.with(this@DetailLigaActivity)
                    .load(detailLigaModel.poster)
                    .centerCrop()
                    .into(imgPosterLiga)
                lblJudul.text = detailLigaModel.nama
                lblEventPertama.text = detailLigaModel.eventpertama
                lblGender.text = detailLigaModel.gender
                lblWebsite.text = detailLigaModel.website
                lblDeskripsi.text = detailLigaModel.deskripsi
                detailLigaProgressbar.visibility = View.GONE
            }
        })

        imgSearch.setOnClickListener {
            startActivity(Intent(this, SearchMatchesActivity::class.java))
        }

        val matchesFragmentPageAdapter =
            MatchesFragmentPageAdapter(supportFragmentManager, tabLayout.tabCount, idliga)

        flPertandingan.setAdapter(matchesFragmentPageAdapter)

        flPertandingan.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                flPertandingan.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        imgBack.setOnClickListener { v -> finish() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
