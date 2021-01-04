package com.example.cs496_tabbed.mathquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.cs496_tabbed.R
import org.w3c.dom.Text

/**
 * Created by acer on 06-Apr-16.
 */
class ResultActivity : AppCompatActivity() {
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
            "Color3" ->  theme.applyStyle(R.style.Color3, true)
            "Color4" ->  theme.applyStyle(R.style.Color4, true)
            "Color5" ->  theme.applyStyle(R.style.Color5, true)
            "Color6" ->  theme.applyStyle(R.style.Color6, true)
            "Color7" ->  theme.applyStyle(R.style.Color7, true)
            "Color8" ->  theme.applyStyle(R.style.Color8, true)
        }

        setContentView(R.layout.activity_result)
        val textResult = findViewById<View>(R.id.textResult) as TextView
        val b = intent.extras
        val score = b!!.getInt("score")
        textResult.text = "Your score is  $score.\nThanks for\nplaying game."
    }

    private fun setActivityBackgroundColor(color: Int) {
        val resultLayout = findViewById<LinearLayout>(R.id.resultLayout)
    }

    /*fun playagain(o: View?) {
        ActivityCompat.finishAffinity(this)
        /*val intent = Intent(this, Options::class.java)
        startActivity(intent)*/
    }*/
}