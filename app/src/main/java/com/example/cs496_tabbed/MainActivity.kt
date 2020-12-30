package com.example.cs496_tabbed

import android.content.pm.PackageManager
import android.os.Bundle
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


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        adapter.addFragment(ContactsFragment(), "Contacts")
        adapter.addFragment(GalleryFragment(), "Gallery")
        adapter.addFragment(FreeFragment(), "Settings")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_contacts_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_photo_library_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_settings_24)
    }

}