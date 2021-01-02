package com.example.cs496_tabbed.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cs496_tabbed.MainActivity
import com.example.cs496_tabbed.R

class GameMainActivity : AppCompatActivity() {

    lateinit var startNewGameButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main)

        startNewGameButton = findViewById(R.id.startNewGameButton)

        startNewGameButton.setOnClickListener {
            val intent = Intent(GameMainActivity@this, GameActivity::class.java)
            startActivity(intent)
        }


    }
}