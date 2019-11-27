package com.example.submissionkotlin3.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submissionkotlin3.R
import com.example.submissionkotlin3.view.fragment.FavoriteFragment
import com.example.submissionkotlin3.view.fragment.LeagueFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.league -> {
                    loadTeamsFragment(savedInstanceState)
                }
                R.id.favorites -> {
                    loadFavoritesFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = R.id.league
    }

    private fun loadTeamsFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.flContainer,
                    LeagueFragment(), LeagueFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadFavoritesFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.flContainer,
                    FavoriteFragment(), FavoriteFragment::class.java.simpleName)
                .commit()
        }
    }
}
