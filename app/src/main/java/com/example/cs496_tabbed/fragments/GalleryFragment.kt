package com.example.cs496_tabbed.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cs496_tabbed.R
import com.example.cs496_tabbed.ViewPagerActivity
import com.example.cs496_tabbed.fragments.adapters.MainAdapter

class GalleryFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lateinit var gridView: GridView
        val playerNames = arrayOf(
            "beach",
            "butterfly",
            "car",
            "coffee",
            "desserts",
            "fox",
            "girl",
            "kitten",
            "paris",
            "pizza",
            "salmon",
            "sunset"
        )
        val playerImages = intArrayOf(
            R.drawable.beach,
            R.drawable.butterfly,
            R.drawable.car,
            R.drawable.coffee,
            R.drawable.desserts,
            R.drawable.fox,
            R.drawable.girl,
            R.drawable.kitten,
            R.drawable.paris,
            R.drawable.pizza,
            R.drawable.salmon,
            R.drawable.sunset
        )
        super.onCreate(savedInstanceState)
        val myView: View = inflater.inflate(R.layout.fragment_gallery, container, false)
        gridView = myView.findViewById(R.id.gridView)
        //gridView = findViewById(R.id.gridView)
        val mainAdapter = MainAdapter(this, playerNames, playerImages)
        //val mainAdapter = MainAdapter(this@MainActivity, playerImages)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent2 = Intent(requireContext(), ViewPagerActivity::class.java)
            startActivity(intent2)
        }
        return myView
    }
}