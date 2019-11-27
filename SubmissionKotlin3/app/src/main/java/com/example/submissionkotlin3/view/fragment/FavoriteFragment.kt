package com.example.submissionkotlin3.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataapi.view.dbhelper.database

import com.example.submissionkotlin3.R
import com.example.submissionkotlin3.model.Favorite
import com.example.submissionkotlin3.view.adapter.FavoriteAdapter
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment() {

    lateinit var rvFavorite:RecyclerView
    private lateinit var favoriteAdapter: FavoriteAdapter

    private var favorites: ArrayList<Favorite> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFavorite = view.findViewById(R.id.rvFavorite)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvFavorite.layoutManager = LinearLayoutManager(context)
        favoriteAdapter = FavoriteAdapter(context!!,favorites)
        rvFavorite.adapter = favoriteAdapter
        showFavorite()
    }

    override fun onResume() {
        super.onResume()
        showFavorite()
    }

    private fun showFavorite(){
        favorites.clear()
        context?.database?.use {
            val result = select(Favorite.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<Favorite>())
            favorites.addAll(favorite)
            favoriteAdapter.notifyDataSetChanged()
        }
    }
}
