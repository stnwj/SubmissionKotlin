package com.example.submissionkotlin2.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionkotlin2.R
import com.example.submissionkotlin2.model.LigaModel
import com.example.submissionkotlin2.view.adapter.LigaAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val ligaArrayList : ArrayList<LigaModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
        rvLiga.layoutManager = LinearLayoutManager(this)
        rvLiga.adapter = LigaAdapter(this, ligaArrayList)

    }

    private fun getData() {
        val id = resources.getStringArray(R.array.id_liga)
        val nama = resources.getStringArray(R.array.nama_liga)
        val deskripsi = resources.getStringArray(R.array.deskripsi_liga)
        val gambar = resources.obtainTypedArray(R.array.image_liga)
        ligaArrayList.clear()
        for (i in id.indices) {
            ligaArrayList.add(
                LigaModel(
                    id[i],
                    nama[i],
                    deskripsi[i],
                    gambar.getResourceId(i, 0)
                )
            )
        }
        gambar.recycle()
    }
}
