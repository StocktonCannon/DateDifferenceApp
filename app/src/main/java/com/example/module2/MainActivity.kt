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
    //creates some lateinit variables, meaning we will assign them later
    private lateinit var yearText : TextView
    private lateinit var monthText : TextView
    private lateinit var dayText : TextView
    private lateinit var calendar : CalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // finds id tags from our layout
        yearText = findViewById<TextView>(R.id.yearText)
        monthText = findViewById<TextView>(R.id.monthText)
        dayText = findViewById<TextView>(R.id.dayText)
        calendar = findViewById<CalendarView>(R.id.calendar)

        //Sets a listener for any change in teh calendar widget.  passes in new variables after a change
        calendar.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->
            val calendarDayOfMonth = dayOfMonth
            val calendarYear = year
            val calendarMonth = month

            // creates a variable for the current date
            val nowCalendar = Calendar.getInstance()
            val nowMonth = nowCalendar.get(MONTH)
            val nowYear = nowCalendar.get(YEAR)
            val nowDayOfMonth = nowCalendar.get(DAY_OF_MONTH)

            //calculates the difference in our entered value with the current date
            val yearDifference = calendarYear - nowYear
            val monthDifference = calendarMonth - nowMonth
            val dateDifference = calendarDayOfMonth - nowDayOfMonth

            //outputs calulated differences to our output text views
            yearText.text = yearDifference.toString() + " year(s) difference"
            monthText.text = monthDifference.toString() + " month(s) difference"
            dayText.text = dateDifference.toString()+ " day(s) difference"
        })

    }

}