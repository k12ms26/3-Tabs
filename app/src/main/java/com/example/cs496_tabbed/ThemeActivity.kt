package com.example.cs496_tabbed

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.cs496_tabbed.MainActivity.Companion.Lang
import com.example.cs496_tabbed.MainActivity.Companion.Selected_Color

open class ThemeActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme"

    val listOfTheme_eng = arrayOf("Blue","Red","Grey","Yellow","Orange","Green","Navy Blue","Purple","Pink")

    val listOfTheme_kor = arrayOf("파랑","빨강","회색","노랑","주황","초록","네이비 블루","보라","분홍")

    val listOfTheme_chi = arrayOf("蓝色","红色","灰色","黄色","橙色","绿色","藏青色","紫色","粉红色") // NEED MODIFICATION

    val listOfTheme_fra = arrayOf("Bleu","Rouge","Gris","Jaune","Orange","Vert","Bleu Marin","Violet","Rose") // NEED MODIFICATION

    val listOfTheme_esp = arrayOf("Azul","Rojo","Gris","Amarillo","Anaranjado","Verde","Azul Marino","Morado","Rosado") // NEED MODIFICATION


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        Selected_Color = sharedPreferences.getString(themeKey, "Color0").toString()
        setContentView(R.layout.activity_theme)



        var listOfTheme = arrayOf<String>()
        when(Lang){
            "eng" -> listOfTheme = listOfTheme_eng
            "kor" -> listOfTheme = listOfTheme_kor
            "chi" -> listOfTheme = listOfTheme_chi
            "fra" -> listOfTheme = listOfTheme_fra
            "esp" -> listOfTheme = listOfTheme_esp
        }


        val listView = findViewById<ListView>(R.id.ColorlistView)
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, listOfTheme
        )
        listView.adapter = arrayAdapter


        listView.setOnItemClickListener { parent, view, position, id ->
            when(position){
                0 -> sharedPreferences.edit().putString(themeKey, "Color0").apply()
                1 -> sharedPreferences.edit().putString(themeKey, "Color1").apply()
                2 -> sharedPreferences.edit().putString(themeKey, "Color2").apply()
                3 -> sharedPreferences.edit().putString(themeKey, "Color3").apply()
                4 -> sharedPreferences.edit().putString(themeKey, "Color4").apply()
                5 -> sharedPreferences.edit().putString(themeKey, "Color5").apply()
                6 -> sharedPreferences.edit().putString(themeKey, "Color6").apply()
                7 -> sharedPreferences.edit().putString(themeKey, "Color7").apply()
                8 -> sharedPreferences.edit().putString(themeKey, "Color8").apply()
            }

            val intent = intent // from getIntent()
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            finish()
            startActivity(intent)
        }

    }

    /*
    override fun onResume() {
        super.onResume()
        when (sharedPreferences.getString(themeKey, "Color0")) {
            "Color0" ->  theme.applyStyle(R.style.Color0, true)
            "Color1" ->  theme.applyStyle(R.style.Color1, true)
            "Color2" ->  theme.applyStyle(R.style.Color2, true)
        }
    }
    */
}