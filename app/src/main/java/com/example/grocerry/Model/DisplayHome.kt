package com.example.grocerry.Model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerry.R


class DisplayHome(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView
    var textView: TextView
    var price: TextView
    var detail: TextView

    init {
        imageView = itemView.findViewById(R.id.productimg)
        textView = itemView.findViewById(R.id.productname)
        price = itemView.findViewById(R.id.productprice)
        detail = itemView.findViewById(R.id.productDetailhome)
    }
}