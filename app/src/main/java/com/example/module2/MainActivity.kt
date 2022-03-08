package com.example.module2

import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.Calendar.*

class MainActivity : AppCompatActivity() {
    private lateinit var yearText : TextView
    private lateinit var monthText : TextView
    private lateinit var dayText : TextView
    private lateinit var calendar : CalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        yearText = findViewById<TextView>(R.id.yearText)
        monthText = findViewById<TextView>(R.id.monthText)
        dayText = findViewById<TextView>(R.id.dayText)
        calendar = findViewById<CalendarView>(R.id.calendar)

        calendar.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->
            val calendarDayOfMonth = dayOfMonth
            val calendarYear = year
            val calendarMonth = month
            val nowCalendar = Calendar.getInstance()
            val nowMonth = nowCalendar.get(MONTH)
            val nowYear = nowCalendar.get(YEAR)
            val nowDayOfMonth = nowCalendar.get(DAY_OF_MONTH)

            val yearDifference = calendarYear - nowYear
            val monthDifference = calendarMonth - nowMonth
            val dateDifference = calendarDayOfMonth - nowDayOfMonth
            yearText.text = yearDifference.toString() + " year(s) difference"
            monthText.text = monthDifference.toString() + " month(s) difference"
            dayText.text = dateDifference.toString()+ " day(s) difference"
        })

    }

}