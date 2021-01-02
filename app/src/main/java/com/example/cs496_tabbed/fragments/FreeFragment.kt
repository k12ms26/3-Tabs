package com.example.cs496_tabbed.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.ListFragment
import com.example.cs496_tabbed.*
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.math.log

class FreeFragment : ListFragment() {
    val settings = arrayOf("Language", "Set Theme Color", "Another Options", "Block Spam")
    var listOfSet = mutableListOf<String>()
    val listOfSet_eng = mutableListOf("Language", "Set Theme Color", "Another Options", "Block Spam")
    val listOfSet_kor = mutableListOf("언어", "테마 색", "다른 기능", "스팸 차단")
    val listOfSet_chi = mutableListOf("语言","主题色","异能", "阻止垃圾邮件") // NEED MODIFICATION
    val listOfSet_fra = mutableListOf("Langue", "Couleur du Thème","Autres Fonctions", "Bloquer le Spam") // NEED MODIFICATION
    val listOfSet_esp = mutableListOf("Wikiproyecto:Lenguas del Mundo", "Color Temático","Distintas Funciones Diferencia Función", "Bloquear Spam") // NEED MODIFICATION

    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme"; val langKey = "currentLang"

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
        val adapter = ArrayAdapter<String>(

            activity!!.applicationContext, android.R.layout.simple_list_item_1, listOfSet
        )
        listAdapter = adapter

        return view
    }

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
            val intent = Intent(requireContext(), SettingsActivity::class.java)
            startActivity(intent)
        }
        if(position == 3){
            val intent = Intent(requireContext(), SpamActivity::class.java)
            startActivity(intent)
        }

    }

}