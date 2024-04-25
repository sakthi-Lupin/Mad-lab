package com.example.scientificcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var displayTextView: TextView

    // Variables to store the operands and operators
    private var operand1 = ""
    private var operand2 = ""
    private var operator = ""

    // Boolean flag to check if the result is displayed
    private var isResultDisplayed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayTextView = findViewById(R.id.displayTextView)
    }

    fun onDigitClicked(view: View) {
        if (isResultDisplayed) {
            clearDisplay()
            isResultDisplayed = false
        }

        val digit = (view as Button).text.toString()
        val currentDisplay = displayTextView.text.toString()

        displayTextView.text = currentDisplay + digit
    }

    fun onOperatorClicked(view: View) {
        if (isResultDisplayed) {
            isResultDisplayed = false
        }

        operand1 = displayTextView.text.toString()
        operator = (view as Button).text.toString()
        displayTextView.text = ""
    }

    fun onEqualsClicked(view: View) {
        operand2 = displayTextView.text.toString()

        val result = when (operator) {
            "+" -> operand1.toDouble() + operand2.toDouble()
            "-" -> operand1.toDouble() - operand2.toDouble()
            "*" -> operand1.toDouble() * operand2.toDouble()
            "/" -> operand1.toDouble() / operand2.toDouble()
            "%" -> operand1.toDouble() % operand2.toDouble()
            else -> 0.0
        }

        displayTextView.text = result.toString()
        isResultDisplayed = true
    }

    fun onClearClicked(view: View) {
        clearDisplay()
    }

    fun onSinClicked(view: View) {
        val value = displayTextView.text.toString().toDouble()
        val result = sin(Math.toRadians(value))
        displayTextView.text = result.toString()
        isResultDisplayed = true
    }

    fun onCosClicked(view: View) {
        val value = displayTextView.text.toString().toDouble()
        val result = cos(Math.toRadians(value))
        displayTextView.text = result.toString()
        isResultDisplayed = true
    }

    fun onTanClicked(view: View) {
        val value = displayTextView.text.toString().toDouble()
        val result = tan(Math.toRadians(value))
        displayTextView.text = result.toString()
        isResultDisplayed = true
    }

    fun onPowClicked(view: View) {
        val value = displayTextView.text.toString().toDouble()
        val result = pow(value, 2.0)
        displayTextView.text = result.toString()
        isResultDisplayed = true
    }

    fun onSqrtClicked(view: View) {
        val value = displayTextView.text.toString().toDouble()
        val result = sqrt(value)
        displayTextView.text = result.toString()
        isResultDisplayed = true
    }

    fun onLogClicked(view: View) {
        val value = displayTextView.text.toString().toDouble()
        val result = log10(value)
        displayTextView.text = result.toString()
        isResultDisplayed = true
    }

    fun onTanInvClicked(view: View) {
        val value = displayTextView.text.toString().toDouble()
        val result = atan(value)
        displayTextView.text = result.toString()
        isResultDisplayed = true
    }

    fun onModClicked(view: View) {
        operand1 = displayTextView.text.toString()
        operator = "%"
        displayTextView.text = ""
    }

    private fun clearDisplay() {
        displayTextView.text = ""
        operand1 = ""
        operand2 = ""
        operator = ""
    }
}
