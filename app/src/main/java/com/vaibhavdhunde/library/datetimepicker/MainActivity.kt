package com.vaibhavdhunde.library.datetimepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vaibhavdhunde.library.datepickerutil.DatePickerDialogFragment
import com.vaibhavdhunde.library.datepickerutil.DatePickerUtil
import com.vaibhavdhunde.library.timepickerutil.TimePickerDialogFragment
import com.vaibhavdhunde.library.timepickerutil.TimePickerUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialogFragment.OnDateSetListener,
    TimePickerDialogFragment.OnTimeSetListener {

    private var selectedDate = Calendar.getInstance().time.time
    private var selectedTime = Calendar.getInstance().time.time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDate(selectedDate) // initial date
        showTime(selectedTime) // initial time

        btn_select_date.setOnClickListener {
            DatePickerUtil.getDate(this, selectedDate)
        }

        btn_select_time.setOnClickListener {
            TimePickerUtil.getTime(this, true, selectedTime)
        }
    }

    override fun onDateSet(timeInMillis: Long) {
        selectedDate = timeInMillis
        showDate(timeInMillis)
    }

    override fun onTimeSet(timeInMillis: Long) {
        selectedTime = timeInMillis
        showTime(timeInMillis)
    }

    private fun showDate(timeInMillis: Long) {
        text_date.text = getDisplayDate(timeInMillis)
    }

    private fun getDisplayDate(timeInMillis: Long): String {
        return SimpleDateFormat("d MMM, yyyy", Locale.getDefault())
            .format(Date(timeInMillis))
    }

    private fun showTime(timeInMillis: Long) {
        text_time.text = getDisplayTime(timeInMillis)
    }

    private fun getDisplayTime(timeInMillis: Long): String {
        return SimpleDateFormat("h:mm a", Locale.getDefault())
            .format(Date(timeInMillis)).toUpperCase(Locale.getDefault())
    }
}
