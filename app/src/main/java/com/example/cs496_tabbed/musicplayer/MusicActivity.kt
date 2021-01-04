package com.example.cs496_tabbed.musicplayer

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cs496_tabbed.MainActivity.Companion.Current_Music
import com.example.cs496_tabbed.MainActivity.Companion.Current_Music_Number
import com.example.cs496_tabbed.MainActivity.Companion.Music_to_Play
import com.example.cs496_tabbed.MainActivity.Companion.mp_Array
import com.example.cs496_tabbed.R
import kotlinx.android.synthetic.main.activity_music.*
import org.w3c.dom.Text

/*
    When Adding Music refer to
    In MainActivity.kt
        mp_Array (increase size accordingly)
    In MusicActivity.kt
        MusicNameList (add in the list)
        Add cases in when(Music_to_Play) in an if & else statement
    In MusicMainActivity.kt
        Adjust setOnItemClickListener when specific item in the list works differently
        Add an element in listOfMusic
 */
class MusicActivity : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    private var totalTime: Int = 0
    val MusicNameList = arrayListOf<String>("Clarion - Scott Buckley", "Jeris - Get Lost", "Skydancer - Scandinavianz", "Echoes - LiQWYD", "Lie 2 You (ft. Dylan Emmet) - Leonell Cassio")

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

        //setContentView(R.layout.activity_music)
        if(Music_to_Play == Current_Music_Number){
            mp = Current_Music
        }else{
            if(Current_Music_Number != 0){
                Current_Music.stop()
                //Current_Music.release()
                if(mp_Array[Music_to_Play-1] == null){//When the selected music has never been played
                    when(Music_to_Play){
                        1 -> mp = MediaPlayer.create(this, R.raw.music1)
                        2 -> mp = MediaPlayer.create(this, R.raw.music2)
                        3 -> mp = MediaPlayer.create(this, R.raw.music3)
                        4 -> mp = MediaPlayer.create(this, R.raw.music4)
                        5 -> mp = MediaPlayer.create(this, R.raw.music5)
                    }
                    mp_Array[Music_to_Play - 1] = mp
                }else{
                    mp = mp_Array[Music_to_Play - 1]!!
                    mp.prepare()
                }
            }else{// when Current_Music_Number == 0, Very first start of the music activity
                when(Music_to_Play){
                    1 -> mp = MediaPlayer.create(this, R.raw.music1)
                    2 -> mp = MediaPlayer.create(this, R.raw.music2)
                    3 -> mp = MediaPlayer.create(this, R.raw.music3)
                    4 -> mp = MediaPlayer.create(this, R.raw.music4)
                    5 -> mp = MediaPlayer.create(this, R.raw.music5)
                }
                mp_Array[Music_to_Play - 1] = mp
            }


            Current_Music = mp
            Current_Music_Number = Music_to_Play
        }

        setContentView(R.layout.activity_music)

        val musicTitle = findViewById<TextView>(R.id.textViewTitle)
        musicTitle.text = MusicNameList[Music_to_Play - 1]
        musicTitle.isSelected = true

        //Sets play/pause button when returning to the activity accordingly
        if (mp.isPlaying){
            playBtn.setBackgroundResource(R.drawable.stop)
        }else{
            playBtn.setBackgroundResource(R.drawable.play)
        }


        mp.isLooping = true
        mp.setVolume(0.5f, 0.5f)
        totalTime = mp.duration

        // Volume Bar
        volumeBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        var volumeNum = progress / 100.0f
                        mp.setVolume(volumeNum, volumeNum)
                    }
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {
                }
                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            }
        )

        // Position Bar
        positionBar.max = totalTime
        positionBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        mp.seekTo(progress)
                    }
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {
                }
                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            }
        )

        // Thread
        Thread(Runnable {
            while (mp != null) {
                try {
                    var msg = Message()
                    msg.what = mp.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                }
            }
        }).start()

    }

    @SuppressLint("HandlerLeak")
    var handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            var currentPosition = msg.what

            // Update positionBar
            positionBar.progress = currentPosition

            // Update Labels
            var elapsedTime = createTimeLabel(currentPosition)
            elapsedTimeLabel.text = elapsedTime

            var remainingTime = createTimeLabel(totalTime - currentPosition)
            remainingTimeLabel.text = "-$remainingTime"
        }
    }

    fun createTimeLabel(time: Int): String {
        var timeLabel = ""
        var min = time / 1000 / 60
        var sec = time / 1000 % 60

        timeLabel = "$min:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }

    fun playBtnClick(v: View) {

        if (mp.isPlaying) {
            // Stop
            mp.pause()
            playBtn.setBackgroundResource(R.drawable.play)
            Log.d("CLICK",mp.toString())
        } else {
            // Start
            mp.start()
            playBtn.setBackgroundResource(R.drawable.stop)
        }
    }


}