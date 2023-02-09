package com.indra.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn0: Button
    private lateinit var btn00: Button

    private lateinit var btndot: Button
    private lateinit var btnmul: Button
    private lateinit var btndiv: Button
    private lateinit var btnmin: Button
    private lateinit var btnadd: Button
    private lateinit var btnclr: Button
    private lateinit var btnclearall: Button
    private lateinit var btneq: Button
    private lateinit var edText: TextView

    private lateinit var mode: String
    private lateinit var firstNumber: String
    private lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        init()
        btn0.setOnClickListener {
            setValue(btn0.text.toString())
        }
        btn00.setOnClickListener {
            setValue(btn00.text.toString())
        }
        btn1.setOnClickListener {
            setValue(btn1.text.toString())
        }
        btn2.setOnClickListener {
            setValue(btn2.text.toString())
        }
        btn3.setOnClickListener {
            setValue(btn3.text.toString())
        }
        btn4.setOnClickListener {
            setValue(btn4.text.toString())
        }
        btn5.setOnClickListener {
            setValue(btn5.text.toString())
        }
        btn6.setOnClickListener {
            setValue(btn6.text.toString())
        }
        btn7.setOnClickListener {
            setValue(btn7.text.toString())
        }
        btn8.setOnClickListener {
            setValue(btn8.text.toString())
        }
        btn9.setOnClickListener {
            setValue(btn9.text.toString())
        }
        btndot.setOnClickListener {
            setValue(btndot.text.toString())
        }
        btnadd.setOnClickListener {
            mode = "+";
            firstNumber = edText.text.toString()
            edText.setText("")
        }
        btndiv.setOnClickListener {
            mode = "/";
            firstNumber = edText.text.toString()
            edText.setText("")
        }
        btnmul.setOnClickListener {
            mode = "*";
            firstNumber = edText.text.toString()
            edText.setText("")
        }
        btnmin.setOnClickListener {
            mode = "-";
            firstNumber = edText.text.toString()
            edText.setText("")
        }
        btnclr.setOnClickListener {
            if (edText.text.length != 0)
                edText.setText(
                    edText.text.toString().subSequence(0, edText.text.toString().length - 1)
                )
        }
        btnclearall.setOnClickListener {
            reset()
        }
        btndot.setOnClickListener {
            if (!edText.text.contains(".")) {
                setValue(btndot.text.toString())
            } else
                Toast.makeText(this, "Only 1 Decimal point allowed", Toast.LENGTH_LONG).show()
        }
        btneq.setOnClickListener {
            if (!mode.equals("")) {
                if (mode.equals("+"))
                    result = "" + (firstNumber.toDouble() + edText.text.toString().toDouble())
                else if (mode.equals("*"))
                    result = "" + (firstNumber.toDouble() * edText.text.toString().toDouble())
                else if (mode.equals("-"))
                    result = "" + (firstNumber.toDouble() - edText.text.toString().toDouble())
                else if (mode.equals("/"))
                    result = "" + (firstNumber.toDouble() / edText.text.toString().toDouble())


                firstNumber = edText.text.toString()
                mode = ""

                if(result.endsWith(".0"))
                    result = ""+result.toDouble().toInt()

                edText.setText(result)
            } else
                Toast.makeText(this, "Select Operation", Toast.LENGTH_LONG).show()
        }
    }

    private fun reset() {
        mode = "";
        firstNumber = ""
        edText.setText("")
    }

    private fun setValue(number: String) {
        edText.setText(edText.text.toString() + number)
    }

    private fun init() {
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btn00 = findViewById(R.id.btn00)
        btndot = findViewById(R.id.btndot)

        btnadd = findViewById(R.id.btnadd)
        btndiv = findViewById(R.id.btndiv)
        btnmul = findViewById(R.id.btnmul)
        btnmin = findViewById(R.id.btnmin)

        btneq = findViewById(R.id.btneq)
        btnclr = findViewById(R.id.btnclr)
        btnclearall = findViewById(R.id.btnclearall)
        edText = findViewById(R.id.edDisplay)
    }
}