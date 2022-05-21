package com.example.ebooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ebooks.Screen.Home_Fragment.view.Home_Fragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun loadFragment()
    {
        var fragmentTransient = supportFragmentManager.beginTransaction()
        fragmentTransient.replace(R.id.frgment_frame_layout,Home_Fragment())
        fragmentTransient.commit()

    }


}