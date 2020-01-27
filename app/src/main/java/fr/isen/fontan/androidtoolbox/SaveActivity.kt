package fr.isen.fontan.androidtoolbox

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_save.*
import org.json.JSONObject
import java.io.File

class SaveActivity : AppCompatActivity() {

    companion object {
        val kFirstNameKey = "kFirstNameKey"
        val kLastNameKey = "kLastNameKey"
        val kBirthDay = "kBirthDay"
        val kFilename = "kFilename"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        saveB.setOnClickListener {
            save()
        }

        readB.setOnClickListener {
            read()
        }

        dateEditText.setOnFocusChangeListener { view, hasFocus ->
            if(hasFocus) {
                dateEditText.clearFocus()
                val dialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        onDateChoose(year, month, dayOfMonth)
                    },
                    1997,
                    7,
                    25)
                dialog.show()
            }
        }
    }

    fun save() {
        if (firstName.text.toString().isNotEmpty() &&
            lastName.text.toString().isNotEmpty() &&
            dateEditText.text.toString().isNotEmpty()) {
            val json = JSONObject()
            json.put(SaveActivity.kFirstNameKey, firstName.text.toString())
            json.put(SaveActivity.kLastNameKey, firstName.text.toString())
            json.put(SaveActivity.kBirthDay, firstName.text.toString())
            Toast.makeText(this, json.toString(), Toast.LENGTH_LONG).show()

            val file = File(cacheDir.absolutePath+"/"+SaveActivity.kFilename)
            file.writeText(json.toString())
    }else {
        Toast.makeText(this, R.string.fields_empty, Toast.LENGTH_LONG).show()
        }
    }

    fun read() {
        val file = File(cacheDir.absolutePath+"/"+SaveActivity.kFilename)
        val readString = file.readText()
        val json = JSONObject(readString)
        Toast.makeText(this,json.getString(SaveActivity.kBirthDay),Toast.LENGTH_LONG).show()
    }

    fun onDateChoose(year: Int, month: Int, day: Int) {

        dateEditText.setText(String.format("%02d/%02d/%04d",day,month+1,year))
        Toast.makeText(this,
            "date : ${dateEditText.text.toString()}",
            Toast.LENGTH_LONG).show()
    }

    fun getAge(year: Int, month: Int, day: Int): Int {
        return 0
    }
}