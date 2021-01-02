package com.example.cs496_tabbed

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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

    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme";val langKey = "currentLang"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(
            "ThemePref",
            Context.MODE_PRIVATE
        )

        when (sharedPreferences.getString(themeKey, "Color0")) {
            "Color0" -> theme.applyStyle(R.style.Color0, true)
            "Color1" -> theme.applyStyle(R.style.Color1, true)
            "Color2" -> theme.applyStyle(R.style.Color2, true)
            "Color3" -> theme.applyStyle(R.style.Color3, true)
            "Color4" -> theme.applyStyle(R.style.Color4, true)
            "Color5" -> theme.applyStyle(R.style.Color5, true)
            "Color6" -> theme.applyStyle(R.style.Color6, true)
            "Color7" -> theme.applyStyle(R.style.Color7, true)
            "Color8" -> theme.applyStyle(R.style.Color8, true)
        }


        setContentView(R.layout.viewpager)

        // Initializing the ViewPager Object
        mViewPager = findViewById<View>(R.id.viewPagerMain) as ViewPager

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = ViewPageAdapter(this@ViewPagerActivity, images)

        // Adding the Adapter to the ViewPager
        mViewPager!!.adapter = mViewPagerAdapter
    }

    override fun onRestart() {
        super.onRestart()
        val intent = intent // from getIntent()
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        startActivity(intent)
    }


}