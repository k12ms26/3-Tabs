package com.example.cs496_tabbed.musicplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.cs496_tabbed.MainActivity.Companion.Music_to_Play
import com.example.cs496_tabbed.R

class MusicMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_main)

        val listOfMusic = arrayOf("Clarion - Scott Buckley", "Jeris - Get Lost", "Skydancer - Scandinavianz", "Echoes - LiQWYD", "Lie 2 You - Leonell Cassio")
        val listView = findViewById<ListView>(R.id.listViewMusic)
        
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