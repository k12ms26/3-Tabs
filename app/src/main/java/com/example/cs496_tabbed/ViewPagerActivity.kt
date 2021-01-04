package com.example.cs496_tabbed

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.cs496_tabbed.adapters.ViewPageAdapter
import java.util.ArrayList


class ViewPagerActivity : AppCompatActivity() {
    //var mPager: ViewPager? = null
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme"

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
        val mPager = findViewById<ViewPager>(R.id.viewPagerMain)
        val images: ArrayList<Int>? = intent.extras?.getIntegerArrayList("images")
        val currentImage = intent.extras?.getInt("current")
        val adapter = ViewPageAdapter(supportFragmentManager, images!!)
        mPager.setAdapter(adapter)
        mPager.setCurrentItem(currentImage!!)
    }
    override fun onRestart() {
        super.onRestart()
        val intent = intent // from getIntent()
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        startActivity(intent)
    }
}
