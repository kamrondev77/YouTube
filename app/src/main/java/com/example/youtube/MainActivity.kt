package com.example.youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.adapter.FeedAdapter
import com.example.youtube.adapter.FilterAdapter
import com.example.youtube.model.Feed
import com.example.youtube.model.Filter

class MainActivity : AppCompatActivity() {

    lateinit var recyclerFeed: RecyclerView
    lateinit var recyclerFilter: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerFilter = findViewById(R.id.recyclerFilter)
        recyclerFilter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.layoutManager = GridLayoutManager(this, 1)

        refreshStoryAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())
    }

    fun refreshStoryAdapter(chats: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, chats)
        recyclerFilter.adapter = adapter
    }

    fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerFeed.adapter = adapter
    }

    fun getAllFilters(): ArrayList<Filter> {
        val filters: ArrayList<Filter> = ArrayList()
        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))

        return filters
    }

    fun getAllFeeds(): ArrayList<Feed> {
        var feeds: ArrayList<Feed> = ArrayList()
        feeds.add(Feed(R.drawable.im_sample1, R.drawable.im1))
        feeds.add(Feed(R.drawable.im_sample2, R.drawable.im2))
        feeds.add(Feed(R.drawable.im_sample3, R.drawable.im3))

        return feeds
    }
}