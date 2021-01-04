package com.example.cs496_tabbed

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cs496_tabbed.TicTacToe.GameMainActivity

class GamesActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme";val langKey = "currentLang"
    var listOfGames = mutableListOf<String>()
    val listOfGames_eng = mutableListOf("Tic Tac Toe", "2048")
    val listOfGames_kor = mutableListOf("틱택토", "2048")
    val listOfGames_chi = mutableListOf("井字游戏", "2048") // NEED MODIFICATION
    val listOfGames_fra = mutableListOf("Jeu de Morpion", "2048") // NEED MODIFICATION
    val listOfGames_esp = mutableListOf("Tres en Línea", "2048") // NEED MODIFICATION

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
        setContentView(R.layout.activity_games)
        val GamestextView = findViewById<TextView>(R.id.GamestextView)

        when(sharedPreferences.getString(langKey, "eng")){
            "eng" -> {
                listOfGames = listOfGames_eng
                GamestextView.text = "Games"
            }
            "kor" -> {
                listOfGames = listOfGames_kor
                GamestextView.text = "게임"
            }
            "chi" -> {
                listOfGames = listOfGames_chi
                GamestextView.text = "游戏"
            }
            "fra" -> {
                listOfGames = listOfGames_fra
                GamestextView.text = "Jeu"
            }
            "esp" -> {
                listOfGames = listOfGames_esp
                GamestextView.text = "juego"
            }
        }

        val listView = findViewById<ListView>(R.id.listViewGames)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfGames)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> {
                    val intent = Intent(this, GameMainActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                }
            }
        }

    }
}

