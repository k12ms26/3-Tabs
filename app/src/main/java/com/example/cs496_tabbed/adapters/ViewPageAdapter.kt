package com.example.cs496_tabbed.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.cs496_tabbed.fragments.ImageFragment


class ViewPageAdapter(fm: FragmentManager, var images: List<Int>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        val fragment = ImageFragment()
        val b = Bundle()
        b.putInt("image", images[position])
        fragment.arguments = b
        return fragment
    }

    override fun getCount(): Int {
        return images.size
    }
}
