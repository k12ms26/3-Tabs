package com.example.cs496_tabbed.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.cs496_tabbed.R

class GalleryFragment : Fragment(), View.OnClickListener {
    var myButton1: ImageView? = null;var myButton2: ImageView? = null;var myButton3: ImageView? = null;var myButton4: ImageView? = null;var myButton5: ImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myView: View = inflater.inflate(R.layout.fragment_gallery, container, false)
        myButton1 = myView.findViewById<View>(R.id.image1) as ImageView
        myButton1!!.setOnClickListener(this)
        myButton2 = myView.findViewById<View>(R.id.image2) as ImageView
        myButton2!!.setOnClickListener(this)
        val myButton6 = myView.findViewById<View>(R.id.image6)
        myButton6!!.setOnClickListener(this)

        //myView.setOnClickListener(this)
        return myView
    }
    override fun onClick(v: View) {
        if(v.id == R.id.image1){
            Toast.makeText(activity!!.baseContext, "Beach", Toast.LENGTH_SHORT).show()
            Log.d("TEST", "TEST")}
        if(v.id == R.id.image2){
            Toast.makeText(requireContext(), "Picture", Toast.LENGTH_SHORT).show()
            Log.d("TEST2", "TEST2")}
        if(v.id == R.id.image6){
            Toast.makeText(requireContext(), "Picture", Toast.LENGTH_SHORT).show()
            Log.d("TEST6", "TEST6")}
        }

    }


