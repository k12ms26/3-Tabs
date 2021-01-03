package com.example.cs496_tabbed.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cs496_tabbed.R
import com.example.cs496_tabbed.ViewPagerActivity
import com.example.cs496_tabbed.adapters.MyAdapter
import java.util.*


class GalleryFragment : Fragment() {
    var gridView: GridView? = null
    var images = ArrayList(
        Arrays.asList(
            R.drawable.beach,
            R.drawable.bicycle,
            R.drawable.butterfly,
            R.drawable.car,
            R.drawable.champagne,
            R.drawable.coffee,
            R.drawable.desserts,
            R.drawable.dome,
            R.drawable.fox,
            R.drawable.giraffe,
            R.drawable.girl,
            R.drawable.iceland,
            R.drawable.kitten,
            R.drawable.paris,
            R.drawable.pizza,
            R.drawable.salmon,
            R.drawable.seagull,
            R.drawable.sunset,
            R.drawable.tree,
            R.drawable.university
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        gridView = view.findViewById(R.id.gridView) as GridView
        val imageAdapter = MyAdapter(images, requireContext())
        gridView?.setAdapter(imageAdapter)
        gridView?.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            val i = Intent(requireContext(), ViewPagerActivity::class.java)
            i.putExtra("images", images)
            i.putExtra("current", position)
            startActivity(i)
        })
        return view
    }
}