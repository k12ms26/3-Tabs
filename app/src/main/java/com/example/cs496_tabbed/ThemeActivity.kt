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
import android.widget.Button
import com.example.cs496_tabbed.MainActivity.Companion.Selected_Color

open class ThemeActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme"


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
        }
        Selected_Color = sharedPreferences.getString(themeKey, "Color0").toString()
        setContentView(R.layout.activity_theme)


    }
    fun onClick(view: View) {
        when(view.id) {
            R.id.Color0 -> {
                sharedPreferences.edit().putString(themeKey, "Color0").apply()
            }

            R.id.Color1 -> {
                sharedPreferences.edit().putString(themeKey, "Color1").apply()
            }

            R.id.Color2-> {
                sharedPreferences.edit().putString(themeKey, "Color2").apply()
            }
            R.id.exit->{
                val intentmove = Intent(Activity(), MainActivity::class.java)
                startActivity(intentmove)
            }
        }
        val intent = intent // from getIntent()
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        when (sharedPreferences.getString(themeKey, "Color0")) {
            "Color0" ->  theme.applyStyle(R.style.Color0, true)
            "Color1" ->  theme.applyStyle(R.style.Color1, true)
            "Color2" ->  theme.applyStyle(R.style.Color2, true)
        }

    }

}