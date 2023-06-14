package com.example.grocerry.Activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerry.Api.Api
import com.example.grocerry.Api.RecycleViewAdapter_Home
import com.example.grocerry.Api.RetrofitClient
import com.example.grocerry.Model.Futureproduct
import com.example.grocerry.Model.ProductListModel
import com.example.grocerry.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        displayData()

    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
    fun displayData() {


        val retrofit=RetrofitClient.buildService(Api::class.java)
        retrofit.productlist().enqueue(
            object:Callback<ProductListModel>
            {
                override fun onResponse(
                    call: Call<ProductListModel>,
                    response: Response<ProductListModel>
                ) {
                    Log.d("989898", "displayData: "+response.body()?.response?.futureproduct?.get(0)?.productname.toString())
                    val futureProList = ArrayList<Futureproduct>()

                    futureProList.addAll(response.body()!!.response!!.futureproduct)
//
                    //
                    Log.d("4545", "onResponse: " + futureProList[0].productname)
                    val recyclerView = findViewById<RecyclerView>(R.id.homedisplay)
                    val gridLayoutManager = GridLayoutManager(
                        applicationContext, 2
                    )
                    recyclerView.layoutManager = gridLayoutManager
                    //Toast.makeText(HomeActivity.this, futureProList.size(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(HomeActivity.this, futureProList.size(), Toast.LENGTH_SHORT).show();
                    Log.d("[456]", "onResponse: " + futureProList.size)


                    val recycleViewAdapter = RecycleViewAdapter_Home(this@HomeActivity, futureProList)
                    recyclerView.adapter = recycleViewAdapter

                }

                override fun onFailure(call: Call<ProductListModel>, t: Throwable) {
                    Log.d("989898", "displayData: ")
                }
            })
    }

    }
