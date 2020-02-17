package jhonatan.sabadi.datetimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class DateAndTimePicker(
    val activity: AppCompatActivity,
    val callback: ((
        year: Int,
        month: Int,
        dayOfMonth: Int,
        hourOfDay: Int,
        minute: Int
    ) -> Unit)? = null,
    val datePattern: String? = null,
    val stringFormattedCallback: ((stringFormatted: String) -> Unit)? = null
) :
    DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    constructor(
        activity: AppCompatActivity,
        dateFormat: String,
        stringFormattedCallback: (stringFormatted: String) -> Unit
    ) : this(
        activity,
        null,
        dateFormat,
        stringFormattedCallback
    )

    init {
        DatePickerFragment(activity, this).show(activity.supportFragmentManager, "data_picker")
    }

    private var year = 0
    private var month = 0
    private var dayOfMonth = 0
    private var hourOfDay = 0
    private var minute = 0

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        this.year = year
        this.month = month
        this.dayOfMonth = dayOfMonth
        TimePickerFragment(
            activity,
            this
        ).show(activity.supportFragmentManager, "data_picker")
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        this.hourOfDay = hourOfDay
        this.minute = minute

        /**
         * Call functions
         */
        completeDate()
        formattedDate()

    }

    private fun completeDate() {
        callback?.invoke(
            year,
            month,
            dayOfMonth,
            hourOfDay,
            minute
        )
    }

    private fun formattedDate() {
        val calendar = Calendar.getInstance().apply {
            set(year, month, dayOfMonth, hourOfDay, minute)
        }
        val date = calendar.time
        val simpleDateFormat = SimpleDateFormat(datePattern)
        val dateFormatted = simpleDateFormat.format(date)
        stringFormattedCallback?.invoke(dateFormatted)
    }

}

inline fun AppCompatActivity.showDateAndTimePicker(
    noinline callback: (
        year: Int,
        month: Int,
        dayOfMonth: Int,
        hourOfDay: Int,
        minute: Int
    ) -> Unit
) {
    DateAndTimePicker(this, callback)
}

inline fun AppCompatActivity.showDateAndTimePicker(
    datePattern: String,
    noinline callback: (
        dateFormatted: String
    ) -> Unit
) {
    DateAndTimePicker(this, datePattern, callback)
}
