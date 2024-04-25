package com.example.graphical

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var drawingLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingLayout = findViewById(R.id.drawingLayout)
    }

    fun drawCircle(view: View) {
        val circleView = object : View(this) {
            override fun onDraw(canvas: Canvas) {
                super.onDraw(canvas)

                val paint = Paint()
                paint.color = Color.BLUE
                paint.style = Paint.Style.FILL

                val centerX = width / 2f
                val centerY = height / 2f
                val radius = 200f

                canvas.drawCircle(centerX, centerY, radius, paint)
            }
        }

        drawingLayout.addView(circleView)
    }

    fun drawEllipse(view: View) {
        val ellipseView = object : View(this) {
            override fun onDraw(canvas: Canvas) {
                super.onDraw(canvas)

                val paint = Paint()
                paint.color = Color.RED
                paint.style = Paint.Style.FILL

                val left = 50f
                val top = 50f
                val right = width - 50f
                val bottom = height - 200f

                canvas.drawOval(RectF(left, top, right, bottom), paint)
            }
        }

        drawingLayout.addView(ellipseView)
    }

    fun drawRectangle(view: View) {
        val rectangleView = object : View(this) {
            override fun onDraw(canvas: Canvas) {
                super.onDraw(canvas)

                val paint = Paint()
                paint.color = Color.GREEN
                paint.style = Paint.Style.FILL

                val left = 50f
                val top = 50f
                val right = width - 50f
                val bottom = height - 200f

                canvas.drawRect(left, top, right, bottom, paint)
            }
        }

        drawingLayout.addView(rectangleView)
    }

    fun drawText(view: View) {
        val textView = object : View(this) {
            override fun onDraw(canvas: Canvas) {
                super.onDraw(canvas)

                val paint = Paint()
                paint.color = Color.BLACK
                paint.textSize = 70f

                val text = "Hello, Android!"

                val textWidth = paint.measureText(text)
                val textHeight = paint.descent() - paint.ascent()

                val x = (width - textWidth) / 2f
                val y = (height + textHeight) / 2f

                canvas.drawText(text, x, y, paint)
            }
        }

        drawingLayout.addView(textView)
    }
}
