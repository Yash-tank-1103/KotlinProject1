package com.example.grocerry.Activity

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerry.Api.Api
import com.example.grocerry.Api.Recycle_Similar_product_Apapter
import com.example.grocerry.Api.RetrofitClient
import com.example.grocerry.Model.Futureproduct
import com.example.grocerry.Model.ProductListModel
import com.example.grocerry.Model.Productlist1

import com.example.grocerry.Model.SimilarProductModel
import com.example.grocerry.R
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val id1= displayData()
        displayRecycleData(id1)






    }
    fun displayData(): String {
        var Productdetail1 = findViewById<TextView>(R.id.ProductDetail1) as TextView
        var Productname1 = findViewById<TextView>(R.id.productname1) as TextView
        var productimage1 = findViewById<ImageView>(R.id.productimage1)as ImageView
        var productpricedetail = findViewById<TextView>(R.id.productpricedetail) as TextView
        var id1="0"

        val retrofit= RetrofitClient.buildService(Api::class.java)
        retrofit.productlist().enqueue(
            object: Callback<ProductListModel>
            {

                override fun onResponse(
                    call: Call<ProductListModel>,
                    response: Response<ProductListModel>
                ) {
                    val futureProList = ArrayList<Futureproduct>(response.body()?.response?.futureproduct)
                    val intent = intent
                    val id = intent.getIntExtra("id", 0)
                    id1=response.body()?.response?.futureproduct?.get(id)?.id.toString()
                    Log.d("989898", "displayData: "+id1)

                    Productname1.setText(response.body()?.response?.futureproduct?.get(id)?.productname.toString())
                    val plain1 = Html.fromHtml(response.body()?.response?.futureproduct?.get(id)?.productdetails).toString()
                    Productdetail1.setText(plain1)
                    productpricedetail.setText("price $"+response.body()?.response?.futureproduct?.get(id)?.prices.toString())
                    Picasso.with(this@ProductDetailActivity).load(response.body()?.response?.futureproduct?.get(id)?.images?.get(0)?.images).into(productimage1)





                }

                override fun onFailure(call: Call<ProductListModel>, t: Throwable) {
                    Log.d("989898", "displayData: ")
                }
            })
        return id1
    }
    fun displayRecycleData(id1:String) {


        val retrofit=RetrofitClient.buildService(Api::class.java)
        retrofit.similarproduct(id1).enqueue(
            object:Callback<SimilarProductModel>
            {
                override fun onResponse(
                    call: Call<SimilarProductModel>,
                    response: Response<SimilarProductModel>
                ) {
                        Log.d("989898", "displayData:12 "+response.body()?.response?.Productlist?.get(0)?.productname.toString())
                    val similarproduct = ArrayList<Productlist1>()
                    response.body()?.response?.Productlist?.let { similarproduct.addAll(it) }


                    val recyclerView = findViewById<RecyclerView>(R.id.similaproductlist)
                    var linearLayoutManager = LinearLayoutManager(
                        this@ProductDetailActivity,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    recyclerView.layoutManager = linearLayoutManager

                    val recycleViewAdapter =Recycle_Similar_product_Apapter(this@ProductDetailActivity, similarproduct)
                    recyclerView.adapter = recycleViewAdapter


                }

                override fun onFailure(call: Call<SimilarProductModel>, t: Throwable) {

                    Log.d("989898", "displayData: ")
                }
            })
    }
}

