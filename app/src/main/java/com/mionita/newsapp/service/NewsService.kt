package com.mionita.newsapp.service

import android.content.Context
import android.os.StrictMode
import androidx.room.Room
import com.mionita.newsapp.model.Articles
import com.mionita.newsapp.model.Favorite
import com.mionita.newsapp.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsService(private val applicationContext: Context?) {

    private val db = RoomDatabase.getInstance(applicationContext!!)

    fun loadNews(): News {
        val request = NewsServiceBuilder.buildService(NewsServiceEndpoints::class.java)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        return request.getNews( "fiWZUGAA8ITTwQvd63XgJPIsr1FWrh2A").execute().body()!!
    }

    fun loadWorldNews(): News {
        val request = NewsServiceBuilder.buildService(NewsServiceEndpoints::class.java)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        return request.getTopStoriesWorld( "fiWZUGAA8ITTwQvd63XgJPIsr1FWrh2A").execute().body()!!
    }

    fun loadScienceNews(): News {
        val request = NewsServiceBuilder.buildService(NewsServiceEndpoints::class.java)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        return request.getTopStoriesScience( "fiWZUGAA8ITTwQvd63XgJPIsr1FWrh2A").execute().body()!!
    }

    suspend fun loadFavoriteNews(): News {
        val favorites = arrayListOf<Favorite>()

        withContext(Dispatchers.IO) {
            favorites.addAll(db.favoriteDao().getAll())
        }

        val articles = arrayListOf<Articles>()
        for (item in favorites) {
            articles.add(item.mapArticle())
        }
        return News(favorites.size, articles)
    }

    suspend fun saveFavoriteNews(favorite: Favorite) {
        withContext(Dispatchers.IO) {
            db.favoriteDao().insertFavorite(favorite)
        }
    }
}