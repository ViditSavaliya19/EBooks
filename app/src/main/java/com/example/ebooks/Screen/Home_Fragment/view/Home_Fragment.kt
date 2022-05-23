package com.example.ebooks.Screen.Home_Fragment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ebooks.Screen.Home_Fragment.controller.Rv_h_Adapter
import com.example.ebooks.Screen.Home_Fragment.controller.home_fire
import com.example.ebooks.databinding.FragmentHomeBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class Home_Fragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    var list = mutableListOf<CarouselItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        slider()

        return binding.root
    }

    fun recycerViewSetup()
    {
        home_fire()
        var adapter = Rv_h_Adapter(activity,home_fire().top_trending_list)
        var layoutManager = GridLayoutManager(activity,3)
        binding.topRvView.layoutManager =layoutManager
        binding.topRvView.adapter = adapter
    }


    fun slider() {
        list.add(
            CarouselItem(
                imageUrl = "https://assets-eu-01.kc-usercontent.com/bcd02f72-b50c-0179-8b4b-5e44f5340bd4/96dad3e6-36f4-4436-ba7b-22a3bdb0396f/The%20best%20fiction%20books%20of%202022%20-%20Header%20-%20FIC.jpg",
                caption = "Ocean of Knowledge"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://d279m997dpfwgl.cloudfront.net/wp/2020/12/2020Booklist-Image.jpg"
            )
        )

        binding.carousel.setData(list)

    }


    override fun onStart() {
        super.onStart()
        recycerViewSetup()

    }
}