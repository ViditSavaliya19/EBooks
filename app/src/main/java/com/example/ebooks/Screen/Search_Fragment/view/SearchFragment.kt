package com.example.ebooks.Screen.Search_Fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ebooks.Screen.Search_Fragment.controller.Search_Adapter
import com.example.ebooks.Screen.Search_Fragment.controller.Search_data
import com.example.ebooks.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
     lateinit var adapter: Search_Adapter
    private val filteredlist = arrayListOf<String>()
    lateinit var binding: FragmentSearchBinding

    var test =
        arrayListOf<String>("Motivation", "Business", "Goal", "Magazine", "Power")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        rv_setUp()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText!!)
                return false
            }
        })


        return binding.root
    }

    fun rv_setUp() {
         adapter = Search_Adapter(activity, Search_data().getSearchData(), test)
        var layoutmanager = GridLayoutManager(activity, 2)
        binding.cateRvView.layoutManager = layoutmanager
        binding.cateRvView.adapter = adapter
    }

    fun filter(text : String)
    {
        for(x in test)
        {
            if (x.toLowerCase().contains(text.toLowerCase())) {

                filteredlist.add(x);
            }
            if (filteredlist.isEmpty()) {
                Toast.makeText(activity, "No Data Found..", Toast.LENGTH_SHORT).show();
            } else {
                adapter.filterList(filteredlist);
            }

        }

    }


}