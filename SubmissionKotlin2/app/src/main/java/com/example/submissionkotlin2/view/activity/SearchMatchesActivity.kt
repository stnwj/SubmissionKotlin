package com.example.submissionkotlin2.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionkotlin2.R
import com.example.submissionkotlin2.controller.LigaController
import com.example.submissionkotlin2.model.MatchesModel
import com.example.submissionkotlin2.view.adapter.MatchesAdapter
import com.example.submissionkotlin2.view.callback.MatchesCallBack
import kotlinx.android.synthetic.main.activity_search_matches.*

class SearchMatchesActivity : AppCompatActivity() {
    var prevArrayList: ArrayList<MatchesModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_matches)
        rvSearch.layoutManager = LinearLayoutManager(this)
        getsearch()
    }

    private fun getsearch() {
        searchmatch.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchProgressbar.visibility = View.VISIBLE
                LigaController().searchTim(query!!, object : MatchesCallBack{
                    override fun onMatchesCallBack(matchesModel: MatchesModel) {
                        prevArrayList.add(matchesModel)
                        rvSearch.adapter = MatchesAdapter(this@SearchMatchesActivity, prevArrayList)
                        searchProgressbar.visibility = View.GONE
                    }

                })
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }
}
