package com.example.cs496_tabbed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cs496_tabbed.R

class GalleryFragment : Fragment(), View.OnClickListener {
    var myButton: ImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myView: View = inflater.inflate(R.layout.fragment_gallery, container, false)
        myButton = myView.findViewById<View>(R.id.image1) as ImageView
        myButton!!.setOnClickListener(this)
        return myView
    }
    override fun onClick(v: View) {
        Toast.makeText(activity?.applicationContext, "Beach", Toast.LENGTH_SHORT).show()
    }

}
