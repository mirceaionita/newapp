package com.mionita.newsapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mionita.newsapp.model.FavoriteNewsContent
import com.mionita.newsapp.model.NewsContent
import com.mionita.newsapp.model.ScienceNewsContent
import com.mionita.newsapp.model.WorldNewsContent
import com.mionita.newsapp.ui.DetailsActivity
import com.mionita.newsapp.ui.favorite.FavoriteNewsFragment
import com.mionita.newsapp.ui.home.NewsFragment
import com.mionita.newsapp.ui.science.ScienceNewsFragment
import com.mionita.newsapp.ui.world.WorldNewsFragment

const val EXTRA_NEWS_TITLE = "com.mionita.newsapp.NEWS.TITLE"
const val EXTRA_NEWS_DETAILS = "com.mionita.newsapp.NEWS.DETAILS"
const val EXTRA_NEWS_IMAGE = "com.mionita.newsapp.NEWS.IMAGE"
const val EXTRA_NEWS_URL = "com.mionita.newsapp.NEWS.URL"
const val EXTRA_NEWS_PUBLISHED_AT = "com.mionita.newsapp.NEWS.PUBLISHED.AT"
const val EXTRA_NEWS_FAVORITE = "com.mionita.newsapp.NEWS.FAVORITE"

class MainActivity : AppCompatActivity(), NewsFragment.OnListFragmentInteractionListener, WorldNewsFragment.OnListFragmentInteractionListener, ScienceNewsFragment.OnListFragmentInteractionListener, FavoriteNewsFragment.OnListFragmentInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_world, R.id.navigation_science, R.id.navigation_favorite))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onListFragmentInteraction(item: NewsContent.NewsItem?) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(EXTRA_NEWS_TITLE, item?.title)
            putExtra(EXTRA_NEWS_DETAILS, item?.details)
            putExtra(EXTRA_NEWS_IMAGE, item?.image)
            putExtra(EXTRA_NEWS_URL, item?.url)
            putExtra(EXTRA_NEWS_PUBLISHED_AT, item?.publishedAt?.time)
        }
        startActivity(intent)
    }

    override fun onListFragmentInteraction(item: WorldNewsContent.NewsItem?) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(EXTRA_NEWS_TITLE, item?.title)
            putExtra(EXTRA_NEWS_DETAILS, item?.details)
            putExtra(EXTRA_NEWS_IMAGE, item?.image)
            putExtra(EXTRA_NEWS_URL, item?.url)
            putExtra(EXTRA_NEWS_PUBLISHED_AT, item?.publishedAt?.time)
        }
        startActivity(intent)
    }

    override fun onListFragmentInteraction(item: ScienceNewsContent.NewsItem?) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(EXTRA_NEWS_TITLE, item?.title)
            putExtra(EXTRA_NEWS_DETAILS, item?.details)
            putExtra(EXTRA_NEWS_IMAGE, item?.image)
            putExtra(EXTRA_NEWS_URL, item?.url)
            putExtra(EXTRA_NEWS_PUBLISHED_AT, item?.publishedAt?.time)
        }
        startActivity(intent)
    }

    override fun onListFragmentInteraction(item: FavoriteNewsContent.NewsItem?) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(EXTRA_NEWS_TITLE, item?.title)
            putExtra(EXTRA_NEWS_DETAILS, item?.details)
            putExtra(EXTRA_NEWS_IMAGE, item?.image)
            putExtra(EXTRA_NEWS_URL, item?.url)
            putExtra(EXTRA_NEWS_PUBLISHED_AT, item?.publishedAt?.time)
        }
        startActivity(intent)
    }
}
