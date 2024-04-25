package com.example.temperatureconvetor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var temperatureInput: EditText
    private lateinit var convertButton: Button
    private lateinit var resultText: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        temperatureInput = findViewById(R.id.temperatureInput)
        convertButton = findViewById(R.id.convertButton)
        resultText = findViewById(R.id.resultText)

        convertButton.setOnClickListener {
            val inputTemperature = temperatureInput.text.toString().toDoubleOrNull()

            if (inputTemperature != null) {
                val result = convertTemperature(inputTemperature)
                resultText.text = "Result: $result"
            } else {
                resultText.text = "Invalid input"
            }
        }
    }

    private fun convertTemperature(temperature: Double): String {
        val celsiusToFahrenheit = (temperature * 9 / 5) + 32
        val fahrenheitToCelsius = (temperature - 32) * 5 / 9
        return "Celsius: $celsiusToFahrenheit°F\nFahrenheit: $fahrenheitToCelsius°C"
    }
}
