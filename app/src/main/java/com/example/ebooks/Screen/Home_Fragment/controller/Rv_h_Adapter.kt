package com.example.ebooks.Screen.Home_Fragment.controller

import android.media.Image
import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ebooks.R
import com.example.ebooks.Screen.Home_Fragment.model.BookModel
import org.imaginativeworld.whynotimagecarousel.utils.setImage

class Rv_h_Adapter(val activity: FragmentActivity?, val topTrendingList: ArrayList<BookModel>) :
    RecyclerView.Adapter<Rv_h_Adapter.ViewData>() {

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image_poster = itemView.findViewById<ImageView>(R.id.book_poster_img)
        var rating = itemView.findViewById<RatingBar>(R.id.ratingBar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(activity).inflate(R.layout.item_book, parent, false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        Glide.with(activity!!).load(topTrendingList[position].img).into(holder.image_poster)
        holder.rating.rating = topTrendingList[position].rate.toFloat()
    }

    override fun getItemCount(): Int {
        return topTrendingList.size
    }
}