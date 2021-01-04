package com.example.cs496_tabbed.musicplayer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.cs496_tabbed.MainActivity.Companion.Music_to_Play
import com.example.cs496_tabbed.R

class MusicMainActivity : AppCompatActivity() {

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

        setContentView(R.layout.activity_music_main)

        val listOfMusic = arrayOf("Clarion - Scott Buckley", "Jeris - Get Lost", "Skydancer - Scandinavianz", "Echoes - LiQWYD", "Lie 2 You - Leonell Cassio")
        val listView = findViewById<ListView>(R.id.listViewMusic)
        val MusictextView = findViewById<TextView>(R.id.MusictextView)

        when(sharedPreferences.getString(langKey, "eng")){
            "eng" -> MusictextView.text = "Music"
            "kor" -> MusictextView.text = "음악"
            "chi" -> MusictextView.text = "音乐"
            "fra" -> MusictextView.text = "Musique"
            "esp" -> MusictextView.text = "Música"
        }

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, listOfMusic
        )
        listView.adapter = arrayAdapter
        
        listView.setOnItemClickListener { parent, view, position, id ->
            Music_to_Play = position + 1
            val intent = Intent(this, MusicActivity::class.java)
            startActivity(intent)
        }
    }
}