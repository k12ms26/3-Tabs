package com.example.cs496_tabbed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.cs496_tabbed.MainActivity.Companion.Lang

open class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (MainActivity.Selected_Color) {
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

        setContentView(R.layout.activity_language)
        val listOfLanguage = arrayOf("English", "한국어", "中文", "Français", "Español")
        val listView = findViewById<ListView>(R.id.languageListView)
        val textView = findViewById<TextView>(R.id.LanguagetextView)

        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, listOfLanguage
        )
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            when(listOfLanguage[position]){
                "English" -> {Lang = "eng"
                              textView.text = "Language: English"
                }
                "한국어" -> {Lang = "kor"
                            textView.text = "언어: 한국어"
                }
                "中文" -> {Lang = "chi"
                            textView.text = "语言: 中文"
                }
                "Français" -> {Lang = "fra"
                            textView.text = "La langue: Français"
                }
                "Español" -> {Lang = "esp"
                            textView.text = "Lengua: Español"
                }
            }
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