package com.gauravk.coordinatorlayoutsample.ui.custom

import android.support.design.widget.AppBarLayout
import android.util.Log
import android.view.View
import com.gauravk.coordinatorlayoutsample.R
import com.gauravk.coordinatorlayoutsample.util.ext.*


const val OFFSET_THRESHOLD = 15

class MultiCollapseListener(appBarLayout: AppBarLayout) : AppBarLayout.OnOffsetChangedListener {

    private val headerOne = appBarLayout.findViewById<View>(R.id.header_1)
    private val headerTwo = appBarLayout.findViewById<View>(R.id.header_2)

    private var isHeaderOneRevealed: Boolean = true
    private var isHeaderTwoRevealed: Boolean = false

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, offset: Int) {
        //val maxScroll = appBarLayout.totalScrollRange
        //val percentage = Math.abs(offset).toFloat() / maxScroll.toFloat()
        Log.i("Main", "Offset $offset")
        handleHeaderVisibility(offset)
    }

    private fun handleHeaderVisibility(offset: Int) {
        if (Math.abs(offset) <= OFFSET_THRESHOLD) {
            headerOne.toVisible()
            headerTwo.toGone()
            if (!isHeaderOneRevealed) {
                headerOne.revealAnimation(AppConstants.ANIM_DURATION)
                isHeaderOneRevealed = true
                isHeaderTwoRevealed = false
            }
        } else {
            headerOne.toGone()
            headerTwo.toVisible()
            if (!isHeaderTwoRevealed) {
                headerTwo.revealAnimation(AppConstants.ANIM_DURATION)
                isHeaderTwoRevealed = true
                isHeaderOneRevealed = false
            }
        }
    }
}