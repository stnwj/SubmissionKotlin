package com.example.submissionkotlin.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.submissionkotlin.model.LigaModel
import com.example.submissionkotlin.view.layouting.UIDetailActivity
import org.jetbrains.anko.setContentView

class DetailActivity : AppCompatActivity() {

    lateinit var uiDetailActivity :UIDetailActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uiDetailActivity = UIDetailActivity()
        uiDetailActivity.setContentView(this)

        val detail = intent.getParcelableExtra<LigaModel>("ligas")

        Glide.with(this).load(detail?.image).into(uiDetailActivity.imgLiga)
        uiDetailActivity.lblNama.text = detail?.nama
        uiDetailActivity.lblDeskrpsi.text = detail?.deskripsi
    }
}
