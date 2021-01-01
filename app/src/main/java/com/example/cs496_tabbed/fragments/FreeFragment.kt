package com.example.cs496_tabbed.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
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
    //R.string.language는 왜 안될까
    val settings = arrayOf("Language", "Set Theme Color", "Another Options")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_free, container, false)

        val adapter = ArrayAdapter<String>(
            activity!!.applicationContext, android.R.layout.simple_list_item_1, settings
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

    }

}