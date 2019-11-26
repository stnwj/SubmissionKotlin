package com.example.submissionkotlin.view.layouting

import android.graphics.Color
import android.graphics.Typeface
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.submissionkotlin.R
import com.example.submissionkotlin.view.ui.DetailActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.appBarLayout

class UIDetailActivity : AnkoComponent<DetailActivity> {
    lateinit var lblNama: TextView
    lateinit var lblDeskrpsi: TextView
    lateinit var imgLiga: ImageView
    override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
        scrollView {
            lparams(width = matchParent, height = matchParent)
            isFillViewport = true
            constraintLayout {
                backgroundColor = ContextCompat.getColor(context, R.color.primaryback)

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

                            textView("Detail Liga") {
                                textColor = Color.WHITE
                                typeface = Typeface.DEFAULT_BOLD
                                textSize = 18.0f

                            }.lparams {
                                marginStart = dip(8)
                            }
                        }
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    topToTop = ConstraintSet.PARENT_ID
                    startToStart = ConstraintSet.PARENT_ID
                    endToEnd = ConstraintSet.PARENT_ID
                }

                imgLiga = imageView {
                    id = R.id.imgLiga
                }.lparams {
                    width = matchParent
                    height = dip(200)
                    topToBottom = R.id.layout1
                    startToStart = ConstraintSet.PARENT_ID
                    endToEnd = ConstraintSet.PARENT_ID
                }
                lblNama = textView("Nama Liga") {
                    id = R.id.lblNama
                    textSize = 18f
                    textColor = Color.WHITE
                    typeface = Typeface.DEFAULT_BOLD
                }.lparams {
                    width = wrapContent
                    height = 0
                    topMargin = dip(16)
                    topToBottom = R.id.imgLiga
                    startToStart = ConstraintSet.PARENT_ID
                    endToEnd = ConstraintSet.PARENT_ID
                }

                cardView {
                    id = R.id.cvDeskripsi
                    backgroundColor = Color.WHITE
                    lblDeskrpsi = textView("Deskripsi") {
                        textSize = 14f
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                        marginStart = dip(8)
                        marginEnd = dip(8)
                        topMargin = dip(8)
                        bottomMargin = dip (8)
                    }
                }.lparams {
                    width = matchParent
                    height = 0
                    marginStart = dip(16)
                    marginEnd = dip(16)
                    topMargin = dip(16)
                    bottomMargin = dip (16)
                    topToBottom = R.id.lblNama
                    startToStart = ConstraintSet.PARENT_ID
                    endToEnd = ConstraintSet.PARENT_ID
                }

            }.lparams{
                width = matchParent
                height = matchParent
                bottomMargin = dip(32)
            }
        }
    }

}