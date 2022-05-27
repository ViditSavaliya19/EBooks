package com.example.ebooks.Screen.Megazine.controller

import android.util.Log
import com.example.ebooks.Screen.Megazine.model.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MegazieneData {

    val database = Firebase.database
    val myRef = database.getReference()
    public val top_trending_list = arrayListOf<CategoryModel>()


    init {
        fireData()
    }

    fun fireData(): ArrayList<CategoryModel> {
        myRef.child("").orderByValue()
        myRef.child("Category").orderByChild("id").equalTo("3").addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                for (x in snapshot.children) {
                    top_trending_list.add(
                        CategoryModel(
                            x.child("id").value.toString(),
                            x.child("name").value.toString(),
                        )
                    )

                    Log.e("TAG", "onDataChange: "+top_trending_list[0].id )
                    Log.e("TAG", "onDataChange: "+top_trending_list[0].name )
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return top_trending_list
    }

}