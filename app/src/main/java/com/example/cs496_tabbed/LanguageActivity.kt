package com.example.cs496_tabbed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cs496_tabbed.MainActivity.Companion.Lang

open class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

    }

    fun onClick(view: View){
        when(view.id){
            R.id.Kor -> Lang = "Korean"
            R.id.Eng -> Lang = "Eng"
        }
    }
}