package com.example.cs496_tabbed.fragments

import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.os.Bundle
import android.provider.Contacts
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.ListFragment
import com.example.cs496_tabbed.R

class ContactsFragment : ListFragment() {
    lateinit var ContactArray: Array<String?>//lateinit var NumberArray: Array<String?>; lateinit var NameArray: Array<String?>
    lateinit var sharedPreferences: SharedPreferences
    val themeKey = "currentTheme";val langKey = "currentLang"

    var listOfSet = mutableListOf<String>()
    val listOfSet_eng = mutableListOf("Search","Tap to share contact details", "Item not found")
    val listOfSet_kor = mutableListOf("검색","탭해서 연락처 공유","번호가 없습니다")
    val listOfSet_chi = mutableListOf("搜索", "点按分享", "电话号码没有了") // NEED MODIFICATION
    val listOfSet_fra = mutableListOf("Chercher", "Appuyez pour partager", "Pas de numéro de téléphone") // NEED MODIFICATION
    val listOfSet_esp = mutableListOf("Buscar", "Toca para compartir", "Sin numero de telefono") // NEED MODIFICATION

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Set Language
        sharedPreferences = this.activity!!.getSharedPreferences(
            "ThemePref",
            Context.MODE_PRIVATE
        )

        when(sharedPreferences.getString(langKey, "eng")){
            "eng" -> listOfSet = listOfSet_eng
            "kor" -> listOfSet = listOfSet_kor
            "chi" -> listOfSet = listOfSet_chi
            "fra" -> listOfSet = listOfSet_fra
            "esp" -> listOfSet = listOfSet_esp
        }

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contacts, container, false)

        val cursor: Cursor? = activity?.contentResolver?.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null)
        activity?.startManagingCursor(cursor)

        val from = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID)
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        //val simple: SimpleCursorAdapter = SimpleCursorAdapter(activity, android.R.layout.simple_list_item_2, cursor, from, to)


        // Bring in Contacts info to build an array of names in contacts
        var i = 0
        val ContactsList = arrayOfNulls<String>(cursor!!.count);// val NameFromContacts = arrayOfNulls<String>(cursor.count); val NumberFromContacts = arrayOfNulls<String>(cursor.count);
        val nameFieldColumnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
        val numberFieldColumnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

        while(cursor.moveToNext()){
            val contactName = cursor.getString(nameFieldColumnIndex)
            val contactNumber = cursor.getString(numberFieldColumnIndex)
            //NameFromContacts[i] = contactName
            //NumberFromContacts[i] = contactNumber
            ContactsList[i] = contactName + "\n" + contactNumber
            i++
        }
        ContactArray = ContactsList
        //NumberArray = NumberFromContacts    // Assign array of numbers from contacts
        //NameArray = NameFromContacts

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, ContactsList)//ContactsList
        listAdapter = adapter

        //search related from here
        val search = view.findViewById<SearchView>(R.id.searchView)
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                if (ContactsList.contains(query)) {
                    adapter.filter.filter(query)
                } else {
                    Toast.makeText(activity, listOfSet[2], Toast.LENGTH_LONG).show()
                }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        // Change the iconified setting to false to make the search bar work by clicking any part of the searchview
        search.setOnClickListener {
            search.isIconified = false
        }

        search.queryHint = listOfSet[0]

        val InfoText = view.findViewById<TextView>(R.id.TextViewInfo)
        InfoText.text = listOfSet[1]


        return view
    }


    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long){
        val texttoShare = ContactArray[position]//"Name: " + NameArray[position] + "\n" + NumberArray[position]

        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, texttoShare)
        intent.type = "text/plain"

        startActivity(Intent.createChooser(intent, "Share contact info to : "))

    }

}