package com.example.grocerry.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {



    private val baseUrl = "https://single2mingal.com/Glossary/public/api/v1/"
    private val client=OkHttpClient.Builder().build()
    private val retrofit=Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(
        client).build()
    fun <T> buildService(service:Class<T>):T {
        return retrofit.create(service)
    }



    }



