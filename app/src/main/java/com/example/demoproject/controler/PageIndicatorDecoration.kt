package com.example.demoproject.controler

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.TypedValue
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PageIndicatorDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val linePaint = Paint().apply {
        color = 0xFF888888.toInt() // Gray color for the line
        style = Paint.Style.STROKE
        strokeWidth = dpToPx(5, context) // Line thickness of 10dp
    }

    private val dotPaint = Paint().apply {
        color = 0xFF888888.toInt() // Gray color for the dots
        style = Paint.Style.FILL
    }

    private val indicatorHeight = dpToPx(5, context) // Height of the indicator section
    private val indicatorItemLength = dpToPx(20, context) // Length of the line or diameter of the dot
    private val indicatorItemPadding = dpToPx(1, context) // Space between indicators
    private val indicatorMarginTop = dpToPx(10, context) // Margin from RecyclerView to indicators

    private fun dpToPx(dp: Int, context: Context): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val itemCount = parent.adapter?.itemCount ?: return
        val totalLength = indicatorItemLength * itemCount
        val paddingBetweenItems = Math.max(0, itemCount - 1) * indicatorItemPadding
        val indicatorTotalWidth = totalLength + paddingBetweenItems
        val indicatorStartX = (parent.width - indicatorTotalWidth) / 2f

        // Position indicators at the end of the RecyclerView with the specified top margin
        val indicatorPosY = parent.height - indicatorHeight / 2f - indicatorMarginTop

        val layoutManager = parent.layoutManager as? LinearLayoutManager ?: return
        val activePosition = layoutManager.findFirstVisibleItemPosition()
        if (activePosition == RecyclerView.NO_POSITION) {
            return
        }

        drawIndicators(c, indicatorStartX, indicatorPosY, itemCount, activePosition)
    }

    private fun drawIndicators(c: Canvas, startX: Float, posY: Float, itemCount: Int, activePosition: Int) {
        var currentPositionX = startX

        for (i in 0 until itemCount) {
            if (i == activePosition) {
                // Draw the line for the active position
                c.drawLine(
                    currentPositionX,
                    posY,
                    currentPositionX + indicatorItemLength,
                    posY,
                    linePaint
                )
            } else {
                // Draw the dot for non-active positions
                c.drawCircle(
                    currentPositionX + indicatorItemLength / 2,
                    posY,
                    indicatorItemLength / 4, // Radius of the dot
                    dotPaint
                )
            }
            currentPositionX += indicatorItemLength + indicatorItemPadding
        }
    }
}

