package com.example.submissionkotlin3.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.submissionkotlin3.R
import com.example.submissionkotlin3.controller.LigaController
import com.example.submissionkotlin3.model.MatchesModel
import com.example.submissionkotlin3.view.adapter.MatchesAdapter
import com.example.submissionkotlin3.view.callback.MatchesCallBack
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class PreviousMatchFragment : Fragment() {
    lateinit var rvPrevMatch: RecyclerView
    lateinit var prevProgressBar: ProgressBar

    var prevArrayList: ArrayList<MatchesModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPrevMatch = view.findViewById(R.id.rvPrevMatch)
        prevProgressBar = view.findViewById(R.id.prevProgressbar)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvPrevMatch.layoutManager = LinearLayoutManager(context)
        getPreviousMatch()

    }

    private fun getPreviousMatch() {
        val idLiga = arguments?.getString("id")

        LigaController().getPreviousMatches(idLiga!!, object : MatchesCallBack {
            override fun onMatchesCallBack(matchesModel: MatchesModel) {
                prevArrayList.add(matchesModel)
                rvPrevMatch.adapter = MatchesAdapter(context!!, prevArrayList)
                prevProgressBar.visibility = View.GONE
            }
        })
    }

}
