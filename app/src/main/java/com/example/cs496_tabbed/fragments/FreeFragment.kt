package com.example.cs496_tabbed.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.ListFragment
import com.example.cs496_tabbed.*
import com.example.cs496_tabbed.musicplayer.MusicActivity
import com.example.cs496_tabbed.musicplayer.MusicMainActivity

val settings = arrayOf("Language", "Set Theme Color", "Browser", "Music", "Games", "Another Options")
var listOfSet = mutableListOf<String>()
val listOfSet_eng = mutableListOf("Language", "Set Theme Color", "Browser", "Music", "Games", "Another Options")
val listOfSet_kor = mutableListOf("언어", "테마 색", "브라우저", "음악", "게임", "다른 기능")
val listOfSet_chi = mutableListOf("语言","主题色","井字游戏","音乐", "游戏", "异能" ) // NEED MODIFICATION
val listOfSet_fra = mutableListOf("Langue", "Couleur du Thème","logiciel de navigation", "Musique", "Jeu", "Autres Fonctions") // NEED MODIFICATION
val listOfSet_esp = mutableListOf("Lenguas del Mundo", "Color Temático", "Navegador","Música", "juego", "Distintas Funciones") // NEED MODIFICATION

var image = intArrayOf(R.drawable.ic_baseline_language_24, R.drawable.ic_baseline_color_lens_24, R.drawable.ic_baseline_dvr_24, R.drawable.ic_baseline_music_note_24, R.drawable.ic_baseline_videogame_asset_24, R.drawable.ic_baseline_apps_24)

lateinit var sharedPreferences: SharedPreferences
val themeKey = "currentTheme"; val langKey = "currentLang"

class FreeFragment : ListFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedPreferences = this.activity!!.getSharedPreferences(
            "ThemePref",
            Context.MODE_PRIVATE
        )

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_free, container, false)
        when(sharedPreferences.getString(langKey, "eng")){
            "eng" -> listOfSet = listOfSet_eng
            "kor" -> listOfSet = listOfSet_kor
            "chi" -> listOfSet = listOfSet_chi
            "fra" -> listOfSet = listOfSet_fra
            "esp" -> listOfSet = listOfSet_esp
        }
        /*
        val adapter = ArrayAdapter<String>(

            activity!!.applicationContext, android.R.layout.simple_list_item_1, listOfSet
        )*/

        val customAdaptor = CustomAdaptor(this.activity!!)

        listAdapter = customAdaptor

        return view
    }

    //언어, 테마 색, 음악, 게임, 다른 옵션 순
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        if (position == 0){
            val intent = Intent(requireContext(), LanguageActivity::class.java)
            startActivity(intent)
        }
        if(position == 1){
            val intent = Intent(requireContext(), ThemeActivity::class.java)
            startActivity(intent)
        }
        if(position == 2){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com")))
        }
        if(position == 3){
            val intent = Intent(requireContext(), MusicMainActivity::class.java)
            startActivity(intent)
        }
        if(position == 4){
            val intent = Intent(requireContext(), GamesActivity::class.java)
            startActivity(intent)
        }
        if(position == 5){
            val intent = Intent(requireContext(), SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
    }


}

class CustomAdaptor(private val context: Activity): BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.layoutInflater
        val view1 = inflater.inflate(R.layout.free_row_data,null)
        val fimage = view1.findViewById<ImageView>(R.id.fImage)
        var fName = view1.findViewById<TextView>(R.id.fname)

        when(sharedPreferences.getString(langKey, "eng")){
            "eng" -> listOfSet = listOfSet_eng
            "kor" -> listOfSet = listOfSet_kor
            "chi" -> listOfSet = listOfSet_chi
            "fra" -> listOfSet = listOfSet_fra
            "esp" -> listOfSet = listOfSet_esp
        }

        fimage.setImageResource(image[p0])
        fName.setText(listOfSet[p0])
        return view1
    }

    override fun getItem(p0: Int): Any {
        return image[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return image.size
    }


}