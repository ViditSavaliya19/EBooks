package com.example.ebooks

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings
import com.example.ebooks.Screen.Home_Fragment.view.Home_Fragment
import com.example.ebooks.Screen.Search_Fragment.view.SearchFragment
import com.example.ebooks.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var bindings: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainBinding.inflate(layoutInflater)


        loadFragment(Home_Fragment())
        bindings.homeBottomBtn.setOnClickListener {

            bindings.homeBottomImg.setColorFilter(getColor(R.color.secondary))
            bindings.homeBottomTxt.setTextColor(getColor(R.color.secondary))
            bindings.searchBottomImg.setColorFilter(getColor(R.color.white))
            bindings.searchBottomTxt.setTextColor(getColor(R.color.white))
            bindings.bookBottomImg.setColorFilter(getColor(R.color.white))
            bindings.bookBottomTxt.setTextColor(getColor(R.color.white))
            bindings.personBottomImg.setColorFilter(getColor(R.color.white))
            bindings.personBottomTxt.setTextColor(getColor(R.color.white))


            loadFragment(Home_Fragment())
        }


        bindings.searchBottombtn.setOnClickListener {
            bindings.homeBottomImg.setColorFilter(getColor(R.color.white))
            bindings.homeBottomTxt.setTextColor(getColor(R.color.white))
            bindings.searchBottomImg.setColorFilter(getColor(R.color.secondary))
            bindings.searchBottomTxt.setTextColor(getColor(R.color.secondary))
            bindings.bookBottomImg.setColorFilter(getColor(R.color.white))
            bindings.bookBottomTxt.setTextColor(getColor(R.color.white))
            bindings.personBottomImg.setColorFilter(getColor(R.color.white))
            bindings.personBottomTxt.setTextColor(getColor(R.color.white))
            loadFragment(SearchFragment())
        }


        bindings.bookBottombtn.setOnClickListener {
            bindings.homeBottomImg.setColorFilter(getColor(R.color.white))
            bindings.homeBottomTxt.setTextColor(getColor(R.color.white))
            bindings.searchBottomImg.setColorFilter(getColor(R.color.white))
            bindings.searchBottomTxt.setTextColor(getColor(R.color.white))
            bindings.bookBottomImg.setColorFilter(getColor(R.color.secondary))
            bindings.bookBottomTxt.setTextColor(getColor(R.color.secondary))
            bindings.personBottomImg.setColorFilter(getColor(R.color.white))
            bindings.personBottomTxt.setTextColor(getColor(R.color.white))
            loadFragment(Home_Fragment())
        }


        bindings.personBottombtn.setOnClickListener {
            bindings.homeBottomImg.setColorFilter(getColor(R.color.white))
            bindings.homeBottomTxt.setTextColor(getColor(R.color.white))
            bindings.searchBottomImg.setColorFilter(getColor(R.color.white))
            bindings.searchBottomTxt.setTextColor(getColor(R.color.white))
            bindings.bookBottomImg.setColorFilter(getColor(R.color.white))
            bindings.bookBottomTxt.setTextColor(getColor(R.color.white))
            bindings.personBottomImg.setColorFilter(getColor(R.color.secondary))
            bindings.personBottomTxt.setTextColor(getColor(R.color.secondary))
            loadFragment(Home_Fragment())
        }
    }


    fun loadFragment(fragment: Fragment) {
        var fragmentTransient = supportFragmentManager.beginTransaction()
        fragmentTransient.replace(R.id.frgment_frame_layout, fragment)
        fragmentTransient.commit()
    }

    



}