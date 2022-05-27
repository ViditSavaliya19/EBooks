package com.example.ebooks.Screen.Megazine.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ebooks.Screen.Home_Fragment.controller.home_fire
import com.example.ebooks.Screen.Megazine.controller.MegazieneData
import com.example.ebooks.Screen.Megazine.controller.Rv_m_Adapter
import com.example.ebooks.databinding.FragmentMegazineBinding

class Megazine_Fragment : Fragment() {

lateinit var binding : FragmentMegazineBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =FragmentMegazineBinding.inflate(layoutInflater)

        recycerViewSetup()



        return binding.root
    }

    fun recycerViewSetup()
    {
        home_fire()
        var adapter = Rv_m_Adapter(activity, MegazieneData().top_trending_list)
        var layoutManager = GridLayoutManager(activity,3)
        binding.mRVView.layoutManager =layoutManager
        binding.mRVView.adapter = adapter
    }

}