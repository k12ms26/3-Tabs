package com.example.cs496_tabbed

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_settings.*
import java.util.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val items = mutableListOf<String>()
        items.add("날짜 수정")
        items.add("시간 수정")
        items.add("브라우저")
        items.add("앱 종료")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listview.adapter = adapter
        listview.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position)

            when (item.toString()) {
                "앱 종료" -> showAlert()
                "날짜 수정" -> showDatePicker()
                "시간 수정" -> showTimePicker()
                "브라우저" -> showWeb()
            }
        }
    }
    private fun showAlert() {
        AlertDialog.Builder(this)
            .setTitle("앱 종료")
            .setPositiveButton("종료") { dialogInterface: DialogInterface, i: Int ->
                ActivityCompat.finishAffinity(this)
                System.exit(0)
            }
            .setNegativeButton("취소") { dialogInterface: DialogInterface, i: Int -> }
            .show()
    }

    private fun showDatePicker() {
        val cal = Calendar.getInstance()
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, y, m, d->
            Toast.makeText(this, "$y-$m-$d", Toast.LENGTH_SHORT).show()
                                                                  }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)).show()
    }

    private fun showTimePicker() {
        val cal = Calendar.getInstance()
        TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, h, m ->
            Toast.makeText(this, "$h:$m", Toast.LENGTH_SHORT).show()
                                                                  }, cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), true).show()
    }

    private fun showWeb() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com")))
    }
}
