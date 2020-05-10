package com.mionita.newsapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Favorite(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "details") val details: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "publishedAt") val publishedAt: Long) {

    fun mapArticle(): Articles {
        return Articles("New York Times", this.author, this.title,
            this.details, this.url, Date(this.publishedAt),
            arrayListOf(Multimedia(this.image, 100, 100, "mediumThreeByTwo440", "")))
    }
}