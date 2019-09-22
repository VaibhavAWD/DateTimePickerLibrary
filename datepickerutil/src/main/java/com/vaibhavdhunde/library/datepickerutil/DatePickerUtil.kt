package com.vaibhavdhunde.library.datepickerutil

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

object DatePickerUtil {

    @Suppress("MemberVisibilityCanBePrivate")
    const val TAG_FRAG_DATE_PICKER_DIALOG =
        "com.vaibhavdhunde.library.datepickerutil.TAG_FRAG_DATE_PICKER_DIALOG"

    fun getDate(context: Context, selectedDate: Long? = null) {
        val datePickerDialogFragment = DatePickerDialogFragment()
        selectedDate?.let {
            val args = Bundle()
            args.putLong(DatePickerDialogFragment.EXTRA_SELECTED_DATE, it)
            datePickerDialogFragment.arguments = args
        }
        if (context is AppCompatActivity) {
            datePickerDialogFragment.show(
                context.supportFragmentManager,
                TAG_FRAG_DATE_PICKER_DIALOG
            )
        } else if (context is Fragment) {
            datePickerDialogFragment.show(
                context.requireFragmentManager(),
                TAG_FRAG_DATE_PICKER_DIALOG
            )
        }
    }
}