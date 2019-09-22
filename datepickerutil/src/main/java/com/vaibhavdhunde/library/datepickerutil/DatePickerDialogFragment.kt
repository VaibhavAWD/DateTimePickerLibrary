package com.vaibhavdhunde.library.datepickerutil

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerDialogFragment : DialogFragment() {

    companion object {
        const val EXTRA_SELECTED_DATE =
            "com.vaibhavdhunde.library.datepickerutil.EXTRA_SELECTED_DATE"
    }

    private lateinit var onDateSetListener: OnDateSetListener

    private lateinit var calendar: Calendar

    private val listener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        val timeInMillis = calendar.timeInMillis
        onDateSetListener.onDateSet(timeInMillis)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onDateSetListener = context as OnDateSetListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                "$context must implement DatePickerDialogFragment.OnDateSetListener"
            )
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return buildDatePickerDialog()
    }

    private fun buildDatePickerDialog(): Dialog {
        initCalendar()
        val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
        val month = calendar[Calendar.MONTH]
        val year = calendar[Calendar.YEAR]
        return DatePickerDialog(requireContext(), listener, year, month, dayOfMonth)
    }

    private fun initCalendar() {
        calendar = Calendar.getInstance()
        calendar.timeInMillis = getSelectedDateInMillis()
    }

    private fun getSelectedDateInMillis(): Long {
        val defaultDateInMillis = Calendar.getInstance().time.time
        return if (arguments != null) {
            arguments!!.getLong(EXTRA_SELECTED_DATE, defaultDateInMillis)
        } else {
            defaultDateInMillis
        }
    }

    interface OnDateSetListener {
        fun onDateSet(timeInMillis: Long)
    }
}