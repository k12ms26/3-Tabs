package com.example.cs496_tabbed.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.ListFragment
import com.example.cs496_tabbed.R


class FreeFragment : ListFragment() {
    val settings = arrayOf("Language", "Set Theme Color")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_free, container, false)

        var adapter = ArrayAdapter<String>(
            activity!!.applicationContext, android.R.layout.simple_list_item_1, settings
        )

        listAdapter = adapter
        //val listview= listView
        val listview = view.findViewById<ListView>(android.R.id.list)

        listview.setOnItemClickListener { parent: AdapterView<*>?, views: View, position: Int, id: Long ->
            fun onListItemClick(listview: ListView, views: View, position: Int, id: Long){
                if(position == 0){
                    Toast.makeText(container?.context, "Clicked 1", Toast.LENGTH_SHORT).show()
                }
                if(position == 1){
                    Toast.makeText(container?.context, "Clicked 2", Toast.LENGTH_SHORT).show()
                }
                Log.d("TEST", "TEST")
            }
            onListItemClick(listview, views, position, id)

        }
        /*
        val listview = view.findViewById<ListView>(android.R.id.list)
        listview.adapter = adapter
        listView.setOnItemClickListener {parent, view, position, id ->
            if(position == 0){
                Toast.makeText(activity, "Clicked 1", Toast.LENGTH_SHORT).show()
            }
            if(position == 1){
                Toast.makeText(activity, "Clicked 1", Toast.LENGTH_SHORT).show()
            }

        }
*/

        return view
    }

    /*
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Int) {
        if(position == 0){
            Toast.makeText(activity?.baseContext, "Clicked 1", Toast.LENGTH_SHORT).show()
        }
        if(position == 1){
            Toast.makeText(activity?.baseContext, "Clicked 2", Toast.LENGTH_SHORT).show()
        }
        Log.d("TEST", "TEST")
    }*/



}