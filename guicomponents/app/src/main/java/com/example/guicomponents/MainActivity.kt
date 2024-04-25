package com.example.guicomponents

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val tv1: TextView = findViewById(R.id.tv1)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val  layout : LinearLayout = findViewById(R.id.main)

        var size : Float =10f
        var i:Int=0
        var j:Int=0
        btn1.setOnClickListener {
            tv1.setTextSize(size)
            size = (size + 5) % 50
        }
        btn2.setOnClickListener {
            when(i%3)
            {
                0 -> tv1.setTextColor(Color.RED)
                1 -> tv1.setTextColor(Color.GREEN)
                2 -> tv1.setTextColor(Color.BLUE)

            }
            i=i+1
        }
        btn3.setOnClickListener {
            when(j%3)
            {
                0 -> layout.setBackgroundColor(Color.RED)
                1 -> layout.setBackgroundColor(Color.GREEN)
                2 -> layout.setBackgroundColor(Color.BLUE)
            }
            j=j+1

        }


    }
}