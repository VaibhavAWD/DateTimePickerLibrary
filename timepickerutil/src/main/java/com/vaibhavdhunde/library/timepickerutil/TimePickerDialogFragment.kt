package com.vaibhavdhunde.library.timepickerutil

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerDialogFragment : DialogFragment() {

    companion object {
        const val EXTRA_SELECTED_TIME =
            "com.vaibhavdhunde.library.timepickerutil.EXTRA_SELECTED_TIME"
    }

    private lateinit var onTimeSetListener: OnTimeSetListener

    private lateinit var calendar: Calendar

    private var isTwentyFourHour = false

    fun setIsTwentyFourHour(isTwentyFourHour: Boolean = false) {
        this.isTwentyFourHour = isTwentyFourHour
    }

    private val listener = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val timeInMillis = calendar.timeInMillis
        onTimeSetListener.onTimeSet(timeInMillis)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onTimeSetListener = context as OnTimeSetListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                "$context must implement TimePickerDialogFragment.OnTimeSetListener"
            )
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return buildTimePickerDialog()
    }

    private fun buildTimePickerDialog(): Dialog {
        initCalendar()
        val hourOfDay = calendar[Calendar.HOUR_OF_DAY]
        val minute = calendar[Calendar.MINUTE]
        return TimePickerDialog(requireContext(), listener, hourOfDay, minute, isTwentyFourHour)
    }

    private fun initCalendar() {
        calendar = Calendar.getInstance()
        calendar.timeInMillis = getSelectedTimeInMillis()
    }

    private fun getSelectedTimeInMillis(): Long {
        val defaultTimeInMillis = Calendar.getInstance().time.time
        return if (arguments != null) {
            arguments!!.getLong(EXTRA_SELECTED_TIME, defaultTimeInMillis)
        } else {
            defaultTimeInMillis
        }
    }

    interface OnTimeSetListener {
        fun onTimeSet(timeInMillis: Long)
    }
}