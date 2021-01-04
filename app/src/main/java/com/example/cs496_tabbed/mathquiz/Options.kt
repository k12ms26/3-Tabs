package com.example.cs496_tabbed.mathquiz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.cs496_tabbed.R

/**
 * Created by acer on 06-Apr-16.
 */
class Options : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme"
    var btnnormal: Button? = null
    var btntime: Button? = null
    var btnuntime: Button? = null
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
        setContentView(R.layout.optionsmenu)
        btnnormal = findViewById<View>(R.id.btnnormal) as Button
        btntime = findViewById<View>(R.id.btntime) as Button
        btnuntime = findViewById<View>(R.id.btnuntime) as Button
        btntime!!.setOnClickListener {
            val intent = Intent(this@Options,
                    NormalQuizActivity::class.java)
            startActivity(intent)
            finish()
        }
        btnuntime!!.setOnClickListener {
            val intent = Intent(this@Options,
                    NoTimeQuizActivity::class.java)
            startActivity(intent)
            finish()
        }
        btnnormal!!.setOnClickListener {
            val intent = Intent(this@Options,
                    NormalQuizActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}