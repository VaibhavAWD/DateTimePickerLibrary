package com.vaibhavdhunde.library.datetimepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vaibhavdhunde.library.datepickerutil.DatePickerDialogFragment
import com.vaibhavdhunde.library.datepickerutil.getDate
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialogFragment.OnDateSetListener {

    private val selectedDate = Calendar.getInstance().time.time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDate(selectedDate) // initial date

        btn_select_date.setOnClickListener {
            getDate(this)
        }
    }

    override fun onDateSet(timeInMillis: Long) {
        showDate(timeInMillis)
    }

    private fun showDate(timeInMillis: Long) {
        text_date.text = getDisplayDate(timeInMillis)
    }

    private fun getDisplayDate(timeInMillis: Long): String {
        return SimpleDateFormat("d MMM, yyyy", Locale.getDefault())
            .format(Date(timeInMillis))
    }
}
