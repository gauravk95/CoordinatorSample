package com.gauravk.coordinatorlayoutsample.util.ext

import android.animation.ValueAnimator
import android.view.View

fun View.toGone() {
    visibility = View.GONE
}

fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toInvisible() {
    visibility = View.INVISIBLE
}

fun View.isGone(): Boolean {
    return visibility == View.GONE
}

fun View.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

fun View.isInvisible() :Boolean{
    return visibility == View.INVISIBLE
}


fun View.revealAnimation(duration: Long){
    val animator = ValueAnimator.ofFloat(0f, 1f)
    animator.duration = duration
    animator.addUpdateListener { animation ->
        val value = animation.animatedValue as Float
        this.alpha = value
    }
    animator.start()
}

fun View.hideAnimation(duration: Long){
    val animator = ValueAnimator.ofFloat(1f, 0f)
    animator.duration = duration
    animator.addUpdateListener { animation ->
        val value = animation.animatedValue as Float
        this.alpha = value
    }
    animator.start()
}