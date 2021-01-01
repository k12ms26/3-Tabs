package com.example.cs496_tabbed

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager


class ViewPagerActivity : AppCompatActivity() {
    // creating object of ViewPager
    var mViewPager: ViewPager? = null

    // images array
    var images = intArrayOf(
        R.drawable.beach, R.drawable.butterfly, R.drawable.car, R.drawable.coffee,
        R.drawable.desserts, R.drawable.fox, R.drawable.girl, R.drawable.kitten
    )

    // Creating Object of ViewPagerAdapter
    var mViewPagerAdapter: ViewPageAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewpager)

        // Initializing the ViewPager Object
        mViewPager = findViewById<View>(R.id.viewPagerMain) as ViewPager

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = ViewPageAdapter(this@ViewPagerActivity, images)

        // Adding the Adapter to the ViewPager
        mViewPager!!.adapter = mViewPagerAdapter
    }
}