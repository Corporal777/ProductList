package com.lessons.productlist

import retrofit2.Response

class PostRepository(private var api: Api) {
    suspend fun getPostList(): Response<ArrayList<Posts>>? {
        return try {
            api.getPosts()
        } catch (e: Exception) {
            null
        }
    }
}