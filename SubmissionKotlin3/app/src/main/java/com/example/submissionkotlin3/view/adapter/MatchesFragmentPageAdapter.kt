package com.example.submissionkotlin3.view.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.submissionkotlin3.view.fragment.NextMatchFragment
import com.example.submissionkotlin3.view.fragment.PreviousMatchFragment

class MatchesFragmentPageAdapter(fm: FragmentManager, behavior: Int, id: String) :
    FragmentStatePagerAdapter(fm, behavior) {
    val behavior = behavior
    val id = id
    override fun getItem(position: Int): Fragment {
        val bundle = Bundle()
        bundle.putString("id", id)

        when (position) {
            0 -> {
                val previousMatchFragment = PreviousMatchFragment()
                previousMatchFragment.arguments = bundle
                return previousMatchFragment
            }
            1 -> {
                val nextMatchFragment = NextMatchFragment()
                nextMatchFragment.arguments = bundle
                return nextMatchFragment
            }
            else ->  throw Throwable()
        }
    }

    override fun getCount(): Int {
        return behavior
    }

}