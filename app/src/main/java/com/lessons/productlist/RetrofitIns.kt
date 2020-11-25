package com.lessons.productlist

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitIns() {


    val BASE_URL: String = "http://jsonplaceholder.typicode.com"

    fun getRetrofitInst(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


}