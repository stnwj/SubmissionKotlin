package com.example.submissionkotlin2.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.submissionkotlin2.R
import com.example.submissionkotlin2.controller.LigaController
import com.example.submissionkotlin2.model.MatchesModel
import com.example.submissionkotlin2.view.adapter.MatchesAdapter
import com.example.submissionkotlin2.view.callback.MatchesCallBack

/**
 * A simple [Fragment] subclass.
 */
class NextMatchFragment : Fragment() {

    lateinit var nextProgressbar: ProgressBar
    lateinit var rvNextMatch: RecyclerView

    var nextArrayList: ArrayList<MatchesModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvNextMatch = view.findViewById(R.id.rvNextMatch)
        nextProgressbar = view.findViewById(R.id.nextProgressbar)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvNextMatch.layoutManager = LinearLayoutManager(context)
        getPreviousMatch()
    }

    private fun getPreviousMatch() {
        val idLiga = arguments?.getString("id")
        LigaController().getNextMatches(idLiga!!, object : MatchesCallBack {
            override fun onMatchesCallBack(matchesModel: MatchesModel) {
                nextArrayList.add(matchesModel)

                rvNextMatch.adapter = MatchesAdapter(context!!,nextArrayList)
                nextProgressbar.visibility = View.GONE
            }
        })
    }
}
