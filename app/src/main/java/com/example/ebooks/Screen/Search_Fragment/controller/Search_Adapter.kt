package com.example.ebooks.Screen.Search_Fragment.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ebooks.R
import com.example.ebooks.Screen.Search_Fragment.model.Model_Search

class Search_Adapter(
    val searchFragment: FragmentActivity?,
    val list: ArrayList<Model_Search>,
    var test: ArrayList<String>
) :
    RecyclerView.Adapter<Search_Adapter.ViewData>() {

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_name = itemView.findViewById<TextView>(R.id.txt_name)

    }

    fun filterList(filterllist: ArrayList<String>) {
        test = filterllist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(searchFragment).inflate(R.layout.item_cate, parent, false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
//        holder.txt_name.text = list[position].name
        holder.txt_name.text = test[position]

    }

    override fun getItemCount(): Int {
//        return list.size
        return test.size
    }
}