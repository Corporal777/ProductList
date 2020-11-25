package com.lessons.productlist

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val BASE_URL: String = "http://jsonplaceholder.typicode.com"


private val retrofit: Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

private val MAIN_API: Api = retrofit.create(Api::class.java)

val networkModule = module {
    single { MAIN_API }
}