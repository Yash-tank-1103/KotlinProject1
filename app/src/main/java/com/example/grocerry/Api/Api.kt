package com.example.grocerry.Api


import com.example.grocerry.Model.LoginModel
import com.example.grocerry.Model.ProductListModel
import com.example.grocerry.Model.SimilarProductModel

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("register")
    fun register(@Field("email") email:String,@Field ("password") password:String): Call<LoginModel>

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email:String,@Field ("password") password:String):Call<LoginModel>

    @POST("productlist")
    fun productlist(): Call<ProductListModel>

    @FormUrlEncoded
    @POST("similarproduct")
    fun similarproduct(@Field("p_id") p_id:String):Call<SimilarProductModel>


}