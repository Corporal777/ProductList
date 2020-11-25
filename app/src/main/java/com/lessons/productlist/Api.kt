package com.lessons.productlist

import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/posts")
    suspend fun getPosts(): Response<ArrayList<Posts>>
}