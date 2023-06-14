package com.example.grocerry.Api

import android.content.Context
import android.content.Intent
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.grocerry.Activity.ProductDetailActivity
import com.example.grocerry.Model.DisplayHome
import com.example.grocerry.Model.Futureproduct
import com.example.grocerry.R
import com.squareup.picasso.Picasso




    class RecycleViewAdapter_Home(var context: Context, futureproducts: ArrayList<Futureproduct>) :
        RecyclerView.Adapter<DisplayHome>() {
        var futureproducts: ArrayList<Futureproduct>

        init {
            this.futureproducts = futureproducts
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayHome {
            return DisplayHome(
                LayoutInflater.from(context).inflate(R.layout.card_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: DisplayHome, position: Int) {

            Picasso.with(context).load(futureproducts[position].images.get(0).images).into(holder.imageView)
            holder.textView.text = futureproducts[position].productname
            holder.price.text = "$" + futureproducts[position].prices
            val plain1 = Html.fromHtml(futureproducts[position].productdetails).toString()

            holder.detail.text = plain1

            holder.itemView.setOnClickListener { v ->

                val i = Intent(context, ProductDetailActivity::class.java)
                i.putExtra("id", position)
                context.startActivity(i)

            }
        }

        override fun getItemCount(): Int {
            return futureproducts.size
        }
    }
