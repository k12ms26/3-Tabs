package com.example.cs496_tabbed.game

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cs496_tabbed.MainActivity
import com.example.cs496_tabbed.R

class GameMainActivity : AppCompatActivity() {
    lateinit var startNewGameButton: Button
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme"; val langKey = "currentLang"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(
            "ThemePref",
            Context.MODE_PRIVATE
        )

        when (sharedPreferences.getString(themeKey, "Color0")) {
            "Color0" -> theme.applyStyle(R.style.Color0, true)
            "Color1" -> theme.applyStyle(R.style.Color1, true)
            "Color2" -> theme.applyStyle(R.style.Color2, true)
            "Color3" -> theme.applyStyle(R.style.Color3, true)
            "Color4" -> theme.applyStyle(R.style.Color4, true)
            "Color5" -> theme.applyStyle(R.style.Color5, true)
            "Color6" -> theme.applyStyle(R.style.Color6, true)
            "Color7" -> theme.applyStyle(R.style.Color7, true)
            "Color8" -> theme.applyStyle(R.style.Color8, true)
        }
        /*when(sharedPreferences.getString(langKey, "eng")){
            "eng" -> listOfGameBtn = listOfGameBtn_eng
            "kor" -> listOfGameBtn = listOfGameBtn_kor
            "chi" -> listOfGameBtn = listOfGameBtn_chi
            "fra" -> listOfGameBtn = listOfGameBtn_fra
            "esp" -> listOfGameBtn = listOfGameBtn_esp
        }*/
        setContentView(R.layout.activity_game_main)

        startNewGameButton = findViewById(R.id.startNewGameButton)

        startNewGameButton.setOnClickListener {
            val intent = Intent(GameMainActivity@this, GameActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onRestart() {
        super.onRestart()
        val intent = intent // from getIntent()
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        startActivity(intent)
    }
}