package com.example.ebooks.Screen.Home_Fragment.controller

import android.util.Log
import com.example.ebooks.Screen.Home_Fragment.model.BookModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class home_fire {

    val database = Firebase.database
    val myRef = database.getReference()
    public val top_trending_list = arrayListOf<BookModel>()


    init {
        fireData()
    }

    fun fireData(): ArrayList<BookModel> {
        myRef.child("TopTrending").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                for (x in snapshot.children) {
                    top_trending_list.add(
                        BookModel(
                            x.child("img").value.toString(),
                            x.child("pdf").value.toString(),
                            x.child("rating").value.toString()
                        )
                    )

                    Log.e("TAG", "onDataChange: "+top_trending_list[0].img )
                    Log.e("TAG", "onDataChange: "+top_trending_list[0].rate )
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return top_trending_list
    }


}