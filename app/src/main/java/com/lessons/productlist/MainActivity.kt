package com.lessons.productlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.compat.ScopeCompat
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private val viewModel : PostViewModel by viewModel()
    private lateinit var adapter: PostsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainInitRV()
        initViewModel()
    }

    private fun mainInitRV() {
        listOfPosts.layoutManager =
            GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        adapter = PostsAdapter()
        listOfPosts.adapter = adapter
    }

    private fun initViewModel() {
        //viewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        viewModel.postList.observe(this, Observer { postList ->
            adapter.update(postList)
        })
    }


    override fun onResume() {
        super.onResume()
        viewModel.getContent()

    }
}