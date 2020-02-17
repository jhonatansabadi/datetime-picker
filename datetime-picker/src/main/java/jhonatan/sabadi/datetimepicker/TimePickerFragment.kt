package jhonatan.sabadi.datetimepicker

import android.app.Activity
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*


internal class TimePickerFragment(
    private val activity: Activity,
    private val listener: TimePickerDialog.OnTimeSetListener
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        return TimePickerDialog(activity, listener, hour, minute, true)
    }
}