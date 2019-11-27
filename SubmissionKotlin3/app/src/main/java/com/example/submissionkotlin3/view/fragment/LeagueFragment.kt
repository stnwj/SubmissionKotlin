package com.example.submissionkotlin3.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.submissionkotlin3.R
import com.example.submissionkotlin3.model.LigaModel
import com.example.submissionkotlin3.view.adapter.LigaAdapter

/**
 * A simple [Fragment] subclass.
 */
class LeagueFragment : Fragment() {

    lateinit var rvLiga: RecyclerView

    val ligaArrayList : ArrayList<LigaModel> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_league, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvLiga = view.findViewById(R.id.rvLiga)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getData()
        rvLiga.layoutManager = LinearLayoutManager(context)
        rvLiga.adapter = LigaAdapter(context!!, ligaArrayList)
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
