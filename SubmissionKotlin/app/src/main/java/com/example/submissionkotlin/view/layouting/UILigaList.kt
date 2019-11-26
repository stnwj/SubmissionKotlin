package com.example.submissionkotlin.view.layouting

import android.graphics.Typeface
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.submissionkotlin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout

class UILigaList : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        constraintLayout {
            lparams(width = matchParent, height = wrapContent)
            val cardview = cardView {
                id = R.id.cvLiga
                radius = dip(0).toFloat()
                elevation = dip(0).toFloat()
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.imgLiga
                    }.lparams {
                        width = dip(100)
                        height = dip(100)
                        marginEnd = dip(16)
                    }

                    linearLayout {
                        orientation = LinearLayout.VERTICAL
                        textView("Nama Liga") {
                            id = R.id.lblNama
                            textSize = 16f
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams {
                            width = wrapContent
                            height = wrapContent
                            bottomMargin = dip(4)
                        }
                        textView("Deskripsi") {
                            id = R.id.cvDeskripsi
                            textSize = 14f
                            maxLines = 4
                            ellipsize = TextUtils.TruncateAt.END
                        }.lparams {
                            width = wrapContent
                            height = wrapContent
                        }
                    }.lparams {
                        width = matchParent
                        height = matchParent
                        marginStart = dip(8)
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    marginStart = dip(8)
                    marginEnd = dip(8)
                    topMargin = dip(8)
                    bottomMargin = dip(8)
                }
            }.lparams {
                width = matchParent
                height = wrapContent
                marginStart = dip(8)
                marginEnd = dip(8)
                topMargin = dip(8)
                bottomMargin = dip(8)
            }

            applyConstraintSet {
                cardview {
                    connect(
                        ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.TOP of ConstraintLayout.LayoutParams.PARENT_ID,
                        ConstraintSetBuilder.Side.START to ConstraintSetBuilder.Side.START of ConstraintLayout.LayoutParams.PARENT_ID,
                        ConstraintSetBuilder.Side.END to ConstraintSetBuilder.Side.END of ConstraintLayout.LayoutParams.PARENT_ID
                    )
                }
            }
        }
    }

}