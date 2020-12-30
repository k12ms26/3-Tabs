package com.example.cs496_tabbed.fragments

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.fragment.app.ListFragment
import com.example.cs496_tabbed.R

class ContactsFragment : ListFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_contacts, container, false)

        var cursor: Cursor? = activity?.contentResolver?.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null)
        activity?.startManagingCursor(cursor)

        var from = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID)
        var to = intArrayOf(android.R.id.text1, android.R.id.text2)
        var simple: SimpleCursorAdapter = SimpleCursorAdapter(activity, android.R.layout.simple_list_item_2, cursor, from, to)

        listAdapter = simple

        return view
    }

}