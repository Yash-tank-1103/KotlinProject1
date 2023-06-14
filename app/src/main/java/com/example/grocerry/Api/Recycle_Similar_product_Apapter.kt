package com.example.grocerry.Api

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerry.Activity.ProductDetailActivity
import com.example.grocerry.Model.*
import com.example.grocerry.R
import com.squareup.picasso.Picasso

class Recycle_Similar_product_Apapter(var context: Context, similarproduct: ArrayList<Productlist1>) :
    RecyclerView.Adapter<DisplayHome>() {
    var similarproduct: ArrayList<Productlist1>

    init {
        this.similarproduct = similarproduct
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayHome {
        return DisplayHome(
            LayoutInflater.from(context).inflate(R.layout.card_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DisplayHome, position: Int) {

        Picasso.with(context).load(similarproduct[position].imagesmore[0].images).into(holder.imageView)
        holder.textView.text = similarproduct[position].productname.toString()
        holder.price.text = "$" +similarproduct[position].prices.toString()
        holder.detail.text= Html.fromHtml(similarproduct[position].productdetails.toString() )


        holder.itemView.setOnClickListener { v ->

            val i = Intent(context, ProductDetailActivity::class.java)
            i.putExtra("id", position)
            context.startActivity(i)

        }
    }

    override fun getItemCount(): Int {
        return similarproduct.size
    }
}