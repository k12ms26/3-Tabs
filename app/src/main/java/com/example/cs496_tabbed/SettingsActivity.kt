package com.example.cs496_tabbed

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.cs496_tabbed.TicTacToe.GameMainActivity
import java.util.*

class SettingsActivity : AppCompatActivity() {
    var listOfSet = mutableListOf<String>()
    val listOfSet_eng = mutableListOf("Edit Date", "Edit Time", "Finish App")
    val listOfSet_kor = mutableListOf("날짜 수정", "시간 수정", "앱 종료")
    val listOfSet_chi = mutableListOf("日期修正","时间修正","浏览器", "结束") // NEED MODIFICATION
    val listOfSet_fra = mutableListOf("Modification la Date", "Modification du Temps","Fin") // NEED MODIFICATION
    val listOfSet_esp = mutableListOf("Modificación de Fecha", "Modificación de Tiempo","Conclusión") // NEED MODIFICATION

    //COLOR SETTING TOP//
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme";val langKey = "currentLang"
    //COLOR SETTING BOTTOM//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //COLOR SETTING TOP//
        sharedPreferences = getSharedPreferences(
            "ThemePref",
            Context.MODE_PRIVATE
        )

        when (sharedPreferences.getString(themeKey, "Color0")) {
            "Color0" ->  theme.applyStyle(R.style.Color0, true)
            "Color1" ->  theme.applyStyle(R.style.Color1, true)
            "Color2" ->  theme.applyStyle(R.style.Color2, true)
            "Color3" ->  theme.applyStyle(R.style.Color3, true)
            "Color4" ->  theme.applyStyle(R.style.Color4, true)
            "Color5" ->  theme.applyStyle(R.style.Color5, true)
            "Color6" ->  theme.applyStyle(R.style.Color6, true)
            "Color7" ->  theme.applyStyle(R.style.Color7, true)
            "Color8" ->  theme.applyStyle(R.style.Color8, true)
        }
    //COLOR SETTING BOTTOM//


        setContentView(R.layout.activity_settings)
        /*val items = mutableListOf<String>()
        items.add("Edit Date")
        items.add("Edit Time")
        items.add("Browser")
        items.add("Finish App")*/
        val listView = findViewById<ListView>(R.id.Settingslistview)
        val SettingstextView = findViewById<TextView>(R.id.SettingstextView)
        when(sharedPreferences.getString(langKey, "eng")){
            "eng" -> {
                listOfSet = listOfSet_eng
                SettingstextView.text = "Another Options"
            }
            "kor" -> {
                listOfSet = listOfSet_kor
                SettingstextView.text = "다른 기능"
            }
            "chi" -> {
                listOfSet = listOfSet_chi
                SettingstextView.text = "异能"
            }
            "fra" -> {
                listOfSet = listOfSet_fra
                SettingstextView.text = "Autres Fonctions"
            }
            "esp" -> {
                listOfSet = listOfSet_esp
                SettingstextView.text = "Distintas Funciones"
            }
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfSet)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            when(position){
                0 -> showDatePicker()
                1 -> showTimePicker()
                2 -> showAlert()
            }

            /*when (item.toString()) {
                "Edit Date" -> showDatePicker()
                "Edit Time" -> showDatePicker()
                "Browser" -> showDatePicker()
                "Finish App" -> showDatePicker()
            }*/
        }
    }
    private fun showAlert() {
        if(listOfSet == listOfSet_eng){
            AlertDialog.Builder(this)
                .setTitle("Do you want to Finish the App?")
                .setPositiveButton("Finish") { dialogInterface: DialogInterface, i: Int ->
                    ActivityCompat.finishAffinity(this)
                    System.exit(0)
                }
                .setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int -> }
                .show()
        }
        else if(listOfSet == listOfSet_kor){
            AlertDialog.Builder(this)
                .setTitle("앱을 종료하시겠습니까?")
                .setPositiveButton("종료") { dialogInterface: DialogInterface, i: Int ->
                    ActivityCompat.finishAffinity(this)
                    System.exit(0)
                }
                .setNegativeButton("취소") { dialogInterface: DialogInterface, i: Int -> }
                .show()
        }
        else if(listOfSet == listOfSet_chi){
            AlertDialog.Builder(this)
                .setTitle("App要结束市场吗？")
                .setPositiveButton("结束") { dialogInterface: DialogInterface, i: Int ->
                    ActivityCompat.finishAffinity(this)
                    System.exit(0)
                }
                .setNegativeButton("取消") { dialogInterface: DialogInterface, i: Int -> }
                .show()
        }
        else if(listOfSet == listOfSet_fra){
            AlertDialog.Builder(this)
                .setTitle("Voulez-vous terminer l'application ?")
                .setPositiveButton("Fin") { dialogInterface: DialogInterface, i: Int ->
                    ActivityCompat.finishAffinity(this)
                    System.exit(0)
                }
                .setNegativeButton("Annuler") { dialogInterface: DialogInterface, i: Int -> }
                .show()
        }
        else{
            AlertDialog.Builder(this)
                .setTitle("¿Podrías cerrar la aplicación?")
                .setPositiveButton("conclusión") { dialogInterface: DialogInterface, i: Int ->
                    ActivityCompat.finishAffinity(this)
                    System.exit(0)
                }
                .setNegativeButton("retractación") { dialogInterface: DialogInterface, i: Int -> }
                .show()
        }
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
