package com.omarcomputer.dialogfragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import java.time.LocalDate
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    private lateinit var dateText : TextView
    private lateinit var btnDate : Button
    private lateinit var btnTime : Button
    private lateinit var btnShowAlert : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dateText = findViewById(R.id.dateText)
        btnDate = findViewById(R.id.btnDate)
        btnTime = findViewById(R.id.btnTime)
        btnShowAlert = findViewById(R.id.btnShowAlert)
        btnDate.setOnClickListener {
            val today = LocalDate.now()
            val datePick =DatePickerDialog(this,{ datePicker: DatePicker, year: Int, month: Int, day: Int ->
                dateText.text ="$day/$month/$year"
            },today.year,today.monthValue,today.dayOfMonth)
            datePick.show()
        }

        btnTime.setOnClickListener {
            val now = LocalTime.now()
            val timePicker = TimePickerDialog(this,{ _: TimePicker, heures: Int, minutes: Int ->
                dateText.text ="$heures:$minutes"
            },now.hour,now.minute,true)
            timePicker.show()
        }
    }
}