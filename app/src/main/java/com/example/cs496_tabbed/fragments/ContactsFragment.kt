package com.example.cs496_tabbed.fragments

import android.content.ContentUris
import android.database.Cursor
import android.os.Bundle
import android.provider.Contacts
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
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
        /*
        // Bring in Contacts info to build an array of names in contacts
        var i = 0
        var NameFromContacts = arrayOfNulls<String>(cursor!!.count)
        val nameFieldColumnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
        while(cursor.moveToNext()){
            var contactName = cursor.getString(nameFieldColumnIndex)
            NameFromContacts[i] = contactName
            i++
        }

        //search related from here
        val search = view.findViewById<SearchView>(R.id.searchView)
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                if(cursor.contains(query)){
                    simple.filter.filter(query)
                }else{
                    Toast.makeText(activity, "Item not found", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                simple.filter.filter(newText)
                return false
            }

        })
        Log.d("TYPE", NameFromContacts[0].toString())
        Log.d("TYPE", NameFromContacts[1].toString())
        Log.d("TYPE", NameFromContacts[2].toString())
        Log.d("TYPE", NameFromContacts[3].toString())
        Log.d("TYPE", NameFromContacts[4].toString())
        Log.d("TYPE", NameFromContacts[5].toString())
        Log.d("TYPE", NameFromContacts[6].toString())
        Log.d("TYPE", NameFromContacts[7].toString())
        Log.d("TYPE", NameFromContacts[8].toString())
        Log.d("TYPE", NameFromContacts[9].toString())
        Log.d("TYPE", NameFromContacts[10].toString())
    */

        return view
    }


}