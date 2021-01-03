package com.example.cs496_tabbed.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class MyAdapter(var imagesIds: List<Int>, var mContext: Context) :
    BaseAdapter() {
    override fun getCount(): Int {
        return imagesIds.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var imageView = convertView as ImageView?

        if (imageView == null) {
            imageView = ImageView(mContext)
            imageView.layoutParams = AbsListView.LayoutParams(350, 450)
            imageView.scaleType = ImageView.ScaleType.FIT_XY
        }
        imageView.setImageResource(imagesIds[position])
        return imageView
    }
}
