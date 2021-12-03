package com.example.apicallingwithretrofit

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val url ="https://fakestoreapi.com/"

interface MyApiInterfce {


    @GET("products")
    fun getData():Call<ArrayList<ModelClass>>
}

object Singlleton{
    val apiInstance: MyApiInterfce
    init {

        val retrofir= Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInstance= retrofir.create(MyApiInterfce::class.java)

    }
}

