package com.example.tempconverter

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle

//class MainActivity : AppCompatActivity() {
 //   override fun onCreate(savedInstanceState: Bundle?) {
   //     super.onCreate(savedInstanceState)
    //    setContentView(R.layout.activity_main)
  //  }
//}
//package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioGroup


class MainActivity : AppCompatActivity() {
    private lateinit var temperatureInput: EditText
    private lateinit var resultTextView: TextView
    private lateinit var conversionRadioGroup: RadioGroup
    private lateinit var convertButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        temperatureInput = findViewById(R.id.getVal)
        resultTextView = findViewById(R.id.showAns)
        conversionRadioGroup = findViewById(R.id.conversionRadioGroup)
        convertButton = findViewById(R.id.ansBtn)
        resetButton = findViewById(R.id.clearBtn)

        convertButton.setOnClickListener {
            convertTemperature()
        }

        resetButton.setOnClickListener {
            resetInputAndResult()
        }
    }

    private fun convertTemperature() {
        val input = temperatureInput.text.toString().trim()
        if (input.isNotEmpty()) {
            val temperature = input.toDouble()
            val selectedConversionId = conversionRadioGroup.checkedRadioButtonId

            if (selectedConversionId == R.id.c2f) {
                val convertedTemperature = celsiusToFahrenheit(temperature)
                resultTextView.text = convertedTemperature.toString()
            } else if (selectedConversionId == R.id.f2c) {
                val convertedTemperature = fahrenheitToCelsius(temperature)
                resultTextView.text = convertedTemperature.toString()
            }
        } else {
            // Handle the case when the input is empty
            resultTextView.text = "0.0"
        }
    }

    private fun celsiusToFahrenheit(celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }

    private fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }

    private fun resetInputAndResult() {
        temperatureInput.text.clear()
        resultTextView.text = "0.0"
        conversionRadioGroup.clearCheck()
    }
}


