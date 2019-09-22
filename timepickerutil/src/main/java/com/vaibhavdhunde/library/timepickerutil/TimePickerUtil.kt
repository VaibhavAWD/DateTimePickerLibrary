package com.vaibhavdhunde.library.timepickerutil

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

object TimePickerUtil {

    @Suppress("MemberVisibilityCanBePrivate")
    const val TAG_FRAG_TIME_PICKER_DIALOG =
        "com.vaibhavdhunde.library.timepickerutil.TAG_FRAG_TIME_PICKER_DIALOG"

    fun getTime(context: Context, isTwentyFourHour: Boolean = false, selectedTime: Long? = null) {
        val timePickerDialogFragment = TimePickerDialogFragment()
        timePickerDialogFragment.setIsTwentyFourHour(isTwentyFourHour)
        selectedTime?.let {
            val args = Bundle()
            args.putLong(TimePickerDialogFragment.EXTRA_SELECTED_TIME, it)
            timePickerDialogFragment.arguments = args
        }
        if (context is AppCompatActivity) {
            timePickerDialogFragment.show(
                context.supportFragmentManager,
                TAG_FRAG_TIME_PICKER_DIALOG
            )
        } else if (context is Fragment) {
            timePickerDialogFragment.show(
                context.requireFragmentManager(),
                TAG_FRAG_TIME_PICKER_DIALOG
            )
        }
    }
}