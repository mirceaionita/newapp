package com.mionita.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.mionita.newsapp.R
import com.mionita.newsapp.model.Favorite
import com.mionita.newsapp.service.NewsService
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.details_activity.*
import kotlinx.coroutines.launch
import kotlin.random.Random

const val EXTRA_NEWS_TITLE = "com.mionita.newsapp.NEWS.TITLE"
const val EXTRA_NEWS_DETAILS = "com.mionita.newsapp.NEWS.DETAILS"
const val EXTRA_NEWS_IMAGE = "com.mionita.newsapp.NEWS.IMAGE"
const val EXTRA_NEWS_URL = "com.mionita.newsapp.NEWS.URL"
const val EXTRA_NEWS_PUBLISHED_AT = "com.mionita.newsapp.NEWS.PUBLISHED.AT"
const val EXTRA_NEWS_FAVORITE = "com.mionita.newsapp.NEWS.FAVORITE"

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        val newsTitle = intent.getStringExtra(EXTRA_NEWS_TITLE)
        val newsDetails = intent.getStringExtra(EXTRA_NEWS_DETAILS)
        val newsImage = intent.getStringExtra(EXTRA_NEWS_IMAGE)
        val newsUrl = intent.getStringExtra(EXTRA_NEWS_URL)
        val publishedAt = intent.getLongExtra(EXTRA_NEWS_PUBLISHED_AT, 0)
        var newsFavorite = intent.getBooleanExtra(EXTRA_NEWS_FAVORITE, false)

        if (newsUrl.isNotEmpty()) {
            Picasso.get().load(newsImage).into(news_details_image)
        }
        news_details_title.text = newsTitle
        news_details_content.text = newsDetails

        favorite.setOnClickListener {
            newsFavorite = if (newsFavorite) {
                favorite.setImageResource(R.drawable.iconfinder_89_171448)
                false
            }else {
                val newsService = NewsService(applicationContext)
                lifecycleScope.launch {
                    newsService.saveFavoriteNews(Favorite(Random.nextInt(), newsTitle!!, newsDetails!!, newsImage!!, newsUrl!!, "New York Times", publishedAt))
                }
                favorite.setImageResource(R.drawable.iconfinder_89_171448_active)
                true
            }
        }
    }
}
