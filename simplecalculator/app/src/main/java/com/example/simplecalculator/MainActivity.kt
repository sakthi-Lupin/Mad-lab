package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var firstNumberEditText: EditText
    private lateinit var secondNumberEditText: EditText
    private lateinit var resultTextView: TextView
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumberEditText = findViewById(R.id.firstNumberEditText)
        secondNumberEditText = findViewById(R.id.secondNumberEditText)
        resultTextView = findViewById(R.id.resultTextView)

        val oneButton: Button = findViewById(R.id.oneButton)
        val twoButton: Button = findViewById(R.id.twoButton)
        val threeButton: Button = findViewById(R.id.threeButton)
        val fourButton: Button = findViewById(R.id.fourButton)
        val fiveButton: Button = findViewById(R.id.fiveButton)
        val sixButton: Button = findViewById(R.id.sixButton)
        val sevenButton: Button = findViewById(R.id.sevenButton)
        val eightButton: Button = findViewById(R.id.eightButton)
        val nineButton: Button = findViewById(R.id.nineButton)
        val zeroButton: Button = findViewById(R.id.zeroButton)

        val addButton: Button = findViewById(R.id.addButton)
        val subtractButton: Button = findViewById(R.id.subtractButton)
        val multiplyButton: Button = findViewById(R.id.multiplyButton)
        val divideButton: Button = findViewById(R.id.divideButton)
        val dotButton: Button = findViewById(R.id.dotButton)
        val equalButton: Button = findViewById(R.id.equalButton)

        oneButton.setOnClickListener { appendNumber("1") }
        twoButton.setOnClickListener { appendNumber("2") }
        threeButton.setOnClickListener { appendNumber("3") }
        fourButton.setOnClickListener { appendNumber("4") }
        fiveButton.setOnClickListener { appendNumber("5") }
        sixButton.setOnClickListener { appendNumber("6") }
        sevenButton.setOnClickListener { appendNumber("7") }
        eightButton.setOnClickListener { appendNumber("8") }
        nineButton.setOnClickListener { appendNumber("9") }
        zeroButton.setOnClickListener { appendNumber("0") }

        dotButton.setOnClickListener { appendNumber(".") }

        addButton.setOnClickListener { appendOperation("+") }
        subtractButton.setOnClickListener { appendOperation("-") }
        multiplyButton.setOnClickListener { appendOperation("*") }
        divideButton.setOnClickListener { appendOperation("/") }

        equalButton.setOnClickListener {
            if (validateInputs(firstNumberEditText, secondNumberEditText)) {
                val firstNumber = firstNumberEditText.text.toString().toDouble()
                val secondNumber = secondNumberEditText.text.toString().toDouble()
                when (operation) {
                    "+" -> {
                        val result = firstNumber + secondNumber
                        resultTextView.text = "Result: $result"
                    }
                    "-" -> {
                        val result = firstNumber - secondNumber
                        resultTextView.text = "Result: $result"
                    }
                    "*" -> {
                        val result = firstNumber * secondNumber
                        resultTextView.text = "Result: $result"
                    }
                    "/" -> {
                        if (secondNumber != 0.0) {
                            val result = firstNumber / secondNumber
                            resultTextView.text = "Result: $result"
                        } else {
                            Toast.makeText(applicationContext, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    private fun appendNumber(number: String) {
        if (operation.isEmpty()) {
            firstNumberEditText.append(number)
        } else {
            secondNumberEditText.append(number)
        }
    }

    private fun appendOperation(op: String) {
        operation = op
    }

    private fun validateInputs(firstNumberEditText: EditText, secondNumberEditText: EditText): Boolean {
        if (firstNumberEditText.text.toString().isEmpty()) {
            firstNumberEditText.error = "Enter a number"
            return false
        }
        if (secondNumberEditText.text.toString().isEmpty()) {
            secondNumberEditText.error = "Enter a number"
            return false
        }
        return true
    }
}
