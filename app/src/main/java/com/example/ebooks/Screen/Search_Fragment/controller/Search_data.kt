package com.example.ebooks.Screen.Search_Fragment.controller

import android.util.Log
import com.example.ebooks.Screen.Search_Fragment.model.Model_Search
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Search_data {


    val database = Firebase.database
    val myRef = database.getReference()
    var list = arrayListOf<Model_Search>()


    init {
        getSearchData()
    }


    fun getSearchData(): ArrayList<Model_Search> {
        myRef.child("Category").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (x in dataSnapshot.children) {
                    list.add(Model_Search(x.child("name").value.toString()))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("TAG", "onCancelled: "+error.toString() )
            }
        })

        return list
    }

}