package com.example.cs496_tabbed.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cs496_tabbed.GalleryActivity
import com.example.cs496_tabbed.R

class GalleryFragment : Fragment(){
    var myButton: ImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myView: View = inflater.inflate(R.layout.fragment_gallery, container, false)
        myButton = myView.findViewById<View>(R.id.image1) as ImageView
        myButton!!.setOnClickListener{
            val intent2 = Intent(requireActivity(), GalleryActivity::class.java)
            requireActivity().startActivity(intent2)
        }
        return myView
    }
    /*
    fun onClick(v: View) {
        if(v.id == R.id.image2) {
            val intent2 = Intent(v.context, GalleryActivity::class.java)
            startActivity(intent2)
            Log.d("TEST","TEST")
        }
    }

     */


}