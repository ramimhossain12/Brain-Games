package com.example.braingame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DatePicker : AppCompatActivity() {
    private var textView: TextView? = null
    private var datePicker: DatePicker? = null
    private var selectButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)
        textView = findViewById<View>(R.id.textViewID) as TextView
        selectButton = findViewById<View>(R.id.buttonID) as Button
        datePicker = findViewById<View>(R.id.datepiccerID) as DatePicker
        textView!!.text = currentDate()
        selectButton!!.setOnClickListener { textView!!.text = currentDate() }
        val actionBar = supportActionBar
        actionBar!!.title = "DatePicker"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    fun currentDate(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("CurrentDate :")
        stringBuilder.append(datePicker!!.dayOfMonth.toString() + "/")
        stringBuilder.append((datePicker!!.month + 1).toString() + "/")
        stringBuilder.append(datePicker!!.year)
        return stringBuilder.toString()
    }
}