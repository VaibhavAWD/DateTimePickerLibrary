package com.vaibhavdhunde.library.datepickerutil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.vaibhavdhunde.library.datepickerutil.DatePickerDialogFragment.Companion.EXTRA_SELECTED_DATE
import com.vaibhavdhunde.library.datepickerutil.DatePickerDialogFragment.OnDateSetListener

const val TAG_FRAG_DATE_PICKER_DIALOG =
    "com.vaibhavdhunde.library.datepickerutil.TAG_FRAG_DATE_PICKER_DIALOG"

fun AppCompatActivity.getDate(listener: OnDateSetListener, selectedDate: Long? = null) {
    val datePickerDialogFragment = DatePickerDialogFragment(listener)
    selectedDate?.let {
        val args = Bundle()
        args.putLong(EXTRA_SELECTED_DATE, it)
        datePickerDialogFragment.arguments = args
    }
    datePickerDialogFragment.show(supportFragmentManager, TAG_FRAG_DATE_PICKER_DIALOG)
}

fun Fragment.getDate(listener: OnDateSetListener, selectedDate: Long? = null) {
    val datePickerDialogFragment = DatePickerDialogFragment(listener)
    selectedDate?.let {
        val args = Bundle()
        args.putLong(EXTRA_SELECTED_DATE, it)
        datePickerDialogFragment.arguments = args
    }
    datePickerDialogFragment.show(requireFragmentManager(), TAG_FRAG_DATE_PICKER_DIALOG)
}