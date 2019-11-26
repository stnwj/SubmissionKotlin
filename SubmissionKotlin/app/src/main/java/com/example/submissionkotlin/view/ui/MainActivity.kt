package com.example.submissionkotlin.view.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionkotlin.R
import com.example.submissionkotlin.model.LigaModel
import com.example.submissionkotlin.view.adapter.LigaAdapter
import com.example.submissionkotlin.view.layouting.UIMainActivity
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    val context: Context = this

    var ligaArrayList: ArrayList<LigaModel> = arrayListOf()
    lateinit var mainActivity: UIMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = UIMainActivity()
        mainActivity.setContentView(this)

        getData()
        mainActivity.rvLiga.layoutManager = LinearLayoutManager(context)
        mainActivity.rvLiga.adapter = LigaAdapter(ligaArrayList){
            val ligas = LigaModel(it.id, it.nama,it.deskripsi, it.image)
//            startActivity<DetailActivity>("ligas" to ligaArrayList.indexOf(it))
            startActivity<DetailActivity>("ligas" to ligas)
        }
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
