package com.example.techlounge

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var studentCount = 0
    private lateinit var checkInButton: Button
    private lateinit var checkOutButton: Button
    private lateinit var countTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkInButton = findViewById(R.id.checkInButton)
        checkOutButton = findViewById(R.id.checkOutButton)
        countTextView = findViewById(R.id.countTextView)

        checkInButton.setOnClickListener {
            studentCount++
            updateCountTextView()
        }

        checkOutButton.setOnClickListener {
            if (studentCount > 0) {
                studentCount--
                updateCountTextView()
            }
        }
    }

    private fun updateCountTextView() {
        countTextView.text = "$studentCount"
    }
}
