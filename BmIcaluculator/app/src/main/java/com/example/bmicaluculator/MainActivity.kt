package com.example.bmicaluculator
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var weightInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightInput = findViewById(R.id.weightInput)
        heightInput = findViewById(R.id.heightInput)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val weight = weightInput.text.toString().toDoubleOrNull()
            val heightInCm = heightInput.text.toString().toDoubleOrNull()

            if (weight != null && heightInCm != null && heightInCm > 0) {
                val bmi = calculateBMI(weight, heightInCm)
                resultTextView.text = "Your BMI: $bmi"
            } else {
                resultTextView.text = "Invalid input"
            }
        }
    }

    private fun calculateBMI(weight: Double, heightInCm: Double): Double {
        // Convert height from centimeters to meters
        val heightInMeters = heightInCm / 100
        return weight / (heightInMeters * heightInMeters)
    }
}
