package com.example.cs496_tabbed

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.cs496_tabbed.fragments.ContactsFragment
import com.example.cs496_tabbed.fragments.FreeFragment
import com.example.cs496_tabbed.fragments.GalleryFragment
import com.example.cs496_tabbed.fragments.adapters.ViewPagerAdapter


open class MainActivity : AppCompatActivity() {
    companion object{
        var Lang = "eng"
        var Selected_Color = "Color0"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (Selected_Color) {
            "Color0" ->  theme.applyStyle(R.style.Color0, true)
            "Color1" ->  theme.applyStyle(R.style.Color1, true)
            "Color2" ->  theme.applyStyle(R.style.Color2, true)
            "Color3" ->  theme.applyStyle(R.style.Color3, true)
            "Color4" ->  theme.applyStyle(R.style.Color4, true)
            "Color5" ->  theme.applyStyle(R.style.Color5, true)
            "Color6" ->  theme.applyStyle(R.style.Color6, true)
            "Color7" ->  theme.applyStyle(R.style.Color7, true)
            "Color8" ->  theme.applyStyle(R.style.Color8, true)
        }

        setContentView(R.layout.activity_main)
        // Asks permission to access Contacts
        if (ContextCompat.checkSelfPermission(this@MainActivity,
                android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity,
                    android.Manifest.permission.READ_CONTACTS)) {
                ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(android.Manifest.permission.READ_CONTACTS), 1)
            } else {
                ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(android.Manifest.permission.READ_CONTACTS), 1)
            }
        }
        setUpTabs()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    if ((ContextCompat.checkSelfPermission(
                            this@MainActivity,
                            android.Manifest.permission.READ_CONTACTS
                        ) ==
                                PackageManager.PERMISSION_GRANTED)
                    ) {
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }
    private fun setUpTabs(){
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val tabs = findViewById<TabLayout>(R.id.tabs)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        when(Lang){
            "kor"-> {adapter.addFragment(ContactsFragment(), applicationContext.getString(R.string.tab_Kor_1))
                        adapter.addFragment(GalleryFragment(), applicationContext.getString(R.string.tab_Kor_2))
                        adapter.addFragment(FreeFragment(), applicationContext.getString(R.string.tab_Kor_3))
            }
            "eng"-> {adapter.addFragment(ContactsFragment(), applicationContext.getString(R.string.tab_Eng_1))
                        adapter.addFragment(GalleryFragment(), applicationContext.getString(R.string.tab_Eng_2))
                        adapter.addFragment(FreeFragment(), applicationContext.getString(R.string.tab_Eng_3))
            }
            "chi" -> {adapter.addFragment(ContactsFragment(), applicationContext.getString(R.string.tab_Chi_1))
                        adapter.addFragment(GalleryFragment(), applicationContext.getString(R.string.tab_Chi_2))
                        adapter.addFragment(FreeFragment(), applicationContext.getString(R.string.tab_Chi_3))
            }
            "fra" -> {adapter.addFragment(ContactsFragment(), applicationContext.getString(R.string.tab_Fra_1))
                    adapter.addFragment(GalleryFragment(), applicationContext.getString(R.string.tab_Fra_2))
                    adapter.addFragment(FreeFragment(), applicationContext.getString(R.string.tab_Fra_3))
            }
            "esp" -> {adapter.addFragment(ContactsFragment(), applicationContext.getString(R.string.tab_Esp_1))
                    adapter.addFragment(GalleryFragment(), applicationContext.getString(R.string.tab_Esp_2))
                    adapter.addFragment(FreeFragment(), applicationContext.getString(R.string.tab_Esp_3))
            }
        }

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_contacts_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_photo_library_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_settings_24)
    }

    // refer to https://developer.android.com/guide/components/activities/activity-lifecycle
    override fun onRestart() {
        super.onRestart()
        val intent = intent // from getIntent()
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        startActivity(intent)
    }
}