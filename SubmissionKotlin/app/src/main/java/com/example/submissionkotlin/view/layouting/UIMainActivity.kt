package com.example.submissionkotlin.view.layouting

import android.graphics.Color
import android.graphics.Typeface
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionkotlin.R
import com.example.submissionkotlin.view.ui.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class UIMainActivity : AnkoComponent<MainActivity> {
    lateinit var rvLiga : RecyclerView
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        constraintLayout {
            lparams(width = matchParent, height = matchParent)
            backgroundColor = ContextCompat.getColor(context,R.color.primaryback)

            appBarLayout {
                id = R.id.layout1
                toolbar {
                    lparams(width = matchParent, height = wrapContent)
                    backgroundColor = ContextCompat.getColor(
                        context,
                        R.color.purple
                    )

                    relativeLayout {
                        lparams(width = matchParent, height = wrapContent)

                        textView("Daftar Liga") {
                            textColor = Color.WHITE
                            typeface = Typeface.DEFAULT_BOLD
                            textSize = 18.0f

                        }.lparams {
                            marginStart = dip(8)
                        }
                    }
                }
            }.lparams{
                width = matchParent
                height = wrapContent
                topToTop = ConstraintSet.PARENT_ID
                startToStart = ConstraintSet.PARENT_ID
                endToEnd = ConstraintSet.PARENT_ID
            }


            rvLiga = recyclerView {
                id = R.id.recyclerviewLiga
            }.lparams {
                width = matchParent
                height = 0
                topMargin = dip(16f)
                marginStart = dip(8f)
                marginEnd = dip(8f)
                bottomMargin = dip(16f)
                topToBottom = R.id.layout1
                startToStart = ConstraintSet.PARENT_ID
                endToEnd = ConstraintSet.PARENT_ID
                bottomToBottom = ConstraintSet.PARENT_ID
            }
        }
    }

}