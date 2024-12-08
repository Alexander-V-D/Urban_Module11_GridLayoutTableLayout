package com.example.urban_module11_gridlayouttablelayout

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var mainToolbar: Toolbar

    private lateinit var inputET: EditText
    private lateinit var resultTV: TextView

    private lateinit var divideBTN: Button
    private lateinit var timesBTN: Button
    private lateinit var subtractBTN: Button
    private lateinit var addBTN: Button

    private lateinit var oneBTN: Button
    private lateinit var twoBTN: Button
    private lateinit var threeBTN: Button
    private lateinit var fourBTN: Button
    private lateinit var fiveBTN: Button
    private lateinit var sixBTN: Button
    private lateinit var sevenBTN: Button
    private lateinit var eightBTN: Button
    private lateinit var nineBTN: Button
    private lateinit var zeroBTN: Button

    private lateinit var resultBTN: Button
    private lateinit var resetBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Калькулятор"
        mainToolbar = findViewById(R.id.mainToolbar)
        setSupportActionBar(mainToolbar)

        inputET = findViewById(R.id.inputET)
        resultTV = findViewById(R.id.resultTV)

        divideBTN = findViewById(R.id.divideBTN)
        timesBTN = findViewById(R.id.timesBTN)
        subtractBTN = findViewById(R.id.subtractBTN)
        addBTN = findViewById(R.id.addBTN)

        oneBTN = findViewById(R.id.oneBTN)
        twoBTN = findViewById(R.id.twoBTN)
        threeBTN = findViewById(R.id.threeBTN)
        fourBTN = findViewById(R.id.fourBTN)
        fiveBTN = findViewById(R.id.fiveBTN)
        sixBTN = findViewById(R.id.sixBTN)
        sevenBTN = findViewById(R.id.sevenBTN)
        eightBTN = findViewById(R.id.eightBTN)
        nineBTN = findViewById(R.id.nineBTN)
        zeroBTN = findViewById(R.id.zeroBTN)

        resultBTN = findViewById(R.id.resultBTN)
        resetBTN = findViewById(R.id.resetBTN)

        oneBTN.setOnClickListener { button -> onButtonClick(button) }
        twoBTN.setOnClickListener { button -> onButtonClick(button) }
        threeBTN.setOnClickListener { button -> onButtonClick(button) }
        fourBTN.setOnClickListener { button -> onButtonClick(button) }
        fiveBTN.setOnClickListener { button -> onButtonClick(button) }
        sixBTN.setOnClickListener { button -> onButtonClick(button) }
        sevenBTN.setOnClickListener { button -> onButtonClick(button) }
        eightBTN.setOnClickListener { button -> onButtonClick(button) }
        nineBTN.setOnClickListener { button -> onButtonClick(button) }
        zeroBTN.setOnClickListener { button -> onButtonClick(button) }

        divideBTN.setOnClickListener { button -> onButtonClick(button) }
        timesBTN.setOnClickListener { button -> onButtonClick(button) }
        subtractBTN.setOnClickListener { button -> onButtonClick(button) }
        addBTN.setOnClickListener { button -> onButtonClick(button) }

        resetBTN.setOnClickListener { button -> onButtonClick(button) }
        resultBTN.setOnClickListener { button -> onButtonClick(button) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    private fun onButtonClick(button: View) {
        if (inputET.text.isNotEmpty()) {
            if (inputET.text.last() == '=') {
                inputET.text.clear()
                resultTV.text = ""
            }
        }
        val input = inputET.text.toString()
        when (button.id) {
            R.id.divideBTN -> {
                if (input.isNotEmpty()) {
                    if (input.last().isDigit()) {
                        inputET.setText(String.format("$input/"))
                    } else {
                        inputET.setText(String.format(input.dropLast(1) + "/"))
                    }
                }
            }

            R.id.timesBTN -> {
                if (input.isNotEmpty()) {
                    if (input.last().isDigit()) {
                        inputET.setText(String.format("$input*"))
                    } else {
                        inputET.setText(String.format(input.dropLast(1) + "*"))
                    }
                }
            }

            R.id.subtractBTN -> {
                if (input.isNotEmpty()) {
                    if (input.last().isDigit()) {
                        inputET.setText(String.format("$input-"))
                    } else {
                        inputET.setText(String.format(input.dropLast(1) + "-"))
                    }
                }
            }

            R.id.addBTN -> {
                if (input.isNotEmpty()) {
                    if (input.last().isDigit()) {
                        inputET.setText(String.format("$input+"))
                    } else {
                        inputET.setText(String.format(input.dropLast(1) + "+"))
                    }
                }
            }

            R.id.oneBTN -> {
                inputET.setText(String.format(input + "1"))
            }

            R.id.twoBTN -> {
                inputET.setText(String.format(input + "2"))
            }

            R.id.threeBTN -> {
                inputET.setText(String.format(input + "3"))
            }

            R.id.fourBTN -> {
                inputET.setText(String.format(input + "4"))
            }

            R.id.fiveBTN -> {
                inputET.setText(String.format(input + "5"))
            }

            R.id.sixBTN -> {
                inputET.setText(String.format(input + "6"))
            }

            R.id.sevenBTN -> {
                inputET.setText(String.format(input + "7"))
            }

            R.id.eightBTN -> {
                inputET.setText(String.format(input + "8"))
            }

            R.id.nineBTN -> {
                inputET.setText(String.format(input + "9"))
            }

            R.id.zeroBTN -> {
                inputET.setText(String.format(input + "0"))
            }

            R.id.resultBTN -> {

                try {
                    val expression = ExpressionBuilder(input).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if (result == longResult.toDouble())
                        resultTV.text = String.format(longResult.toString())
                    else
                        resultTV.text = String.format(result.toString())

                } catch (e: Exception) {
                    Log.d("Exception", " message : " + e.message)
                }
                if (input.last().isDigit()) {
                    inputET.setText(String.format("$input="))
                } else {
                    inputET.setText(String.format(input.dropLast(1) + "="))
                }
            }

            R.id.resetBTN -> {
                inputET.text.clear()
                resultTV.text = ""
            }
        }
    }
}