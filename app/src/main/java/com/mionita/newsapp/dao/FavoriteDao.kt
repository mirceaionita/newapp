package com.mionita.newsapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mionita.newsapp.model.Favorite

@Dao
interface FavoriteDao {

    @Insert
    fun insertFavorite(favorite: Favorite)

    @Query("SELECT * " +
            "FROM favorite")
    fun getAll(): List<Favorite>

    @Query("SELECT * " +
            "FROM favorite WHERE title LIKE :title LIMIT 1")
    fun findByTitle(title: String): Favorite

    @Query("SELECT * " +
            "FROM favorite WHERE url LIKE :url LIMIT 1")
    fun findByUrl(url: String): Favorite
}