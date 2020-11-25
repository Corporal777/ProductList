package com.lessons.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostViewModel constructor(val repo: PostRepository) : ViewModel() {
    private val _postList = MutableLiveData<ArrayList<Posts>>()
    val postList: LiveData<ArrayList<Posts>> = _postList

    fun getContent() {
        val retService = RetrofitIns().getRetrofitInst().create(Api::class.java)
        viewModelScope.launch {

            val response = repo.getPostList()
            if (response != null) {
                _postList.value = response.body()
            }


           val response = retService.getPosts()
//             _postList.value = response.body()


        }


    }


}

