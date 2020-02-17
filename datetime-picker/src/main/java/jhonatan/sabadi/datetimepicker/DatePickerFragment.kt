package jhonatan.sabadi.datetimepicker


import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import java.util.*

internal class DatePickerFragment(
    private val activity: AppCompatActivity,
    private val listener: DatePickerDialog.OnDateSetListener

) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        hideKeyboard()

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, listener, year, month, day)
    }

    private fun hideKeyboard() {
        val inputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
    }

}