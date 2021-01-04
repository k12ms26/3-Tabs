package com.example.cs496_tabbed.game

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.cs496_tabbed.MainActivity
import com.example.cs496_tabbed.R
import kotlinx.android.synthetic.main.activity_game_main.*

class GameMainActivity : AppCompatActivity() {
    lateinit var startNewGameButton: Button
    lateinit var titleTextView: TextView
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme"; val langKey = "currentLang"
    var listOfSet = mutableListOf<String>()
    val listOfSet_eng = mutableListOf("Edit Date", "Edit Time", "Browser", "Tic Tac Toe", "Finish App")
    val listOfSet_kor = mutableListOf("날짜 수정", "시간 수정", "브라우저", "틱택토", "앱 종료")
    val listOfSet_chi = mutableListOf("日期修正","时间修正","浏览器", "井字游戏", "结束") // NEED MODIFICATION
    val listOfSet_fra = mutableListOf("Modification la Date", "Modification du Temps","logiciel de navigation","Jeu de Morpion", "Fin") // NEED MODIFICATION
    val listOfSet_esp = mutableListOf("Modificación de Fecha", "Modificación de Tiempo","Navegador","Tres en Línea", "Conclusión") // NEED MODIFICATION


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

        setContentView(R.layout.activity_game_main)

        startNewGameButton = findViewById(R.id.startNewGameButton)
        //titleTextView = findViewById(R.id.titleTextView)
        when(sharedPreferences.getString(langKey, "eng")){
            "eng" -> startNewGameButton.text = "Start New Game"
            "kor" -> startNewGameButton.text = "게임 시작하기"
            "chi" -> startNewGameButton.text = "游戏开始"
            "fra" -> startNewGameButton.text = "Début du jeu"
            "esp" -> startNewGameButton.text = "¡A jugar!"
        }

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