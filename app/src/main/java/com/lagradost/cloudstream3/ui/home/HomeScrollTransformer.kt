package com.lagradost.cloudstream3.ui.home

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class HomeScrollTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        //page.translationX = -position * page.width / 2.0f

        //val params = RecyclerView.LayoutParams(
        //    RecyclerView.LayoutParams.MATCH_PARENT,
        //    0
        //)
        //page.layoutParams = params
        //progressBar?.layoutParams = params

        val safePosition = position.coerceIn(-1f, 1f)
        val distance = kotlin.math.abs(safePosition)

        // Subtle premium carousel depth; no content, focus, or navigation behavior changes.
        val scale = 1f - (0.045f * distance)
        page.scaleX = scale
        page.scaleY = scale
        page.alpha = 1f - (0.16f * distance)
        page.translationZ = (1f - distance) * 2f * page.resources.displayMetrics.density

        val padding = (-position * page.width / 2).toInt()
        page.setPadding(padding, 0, -padding, 0)
    }
}