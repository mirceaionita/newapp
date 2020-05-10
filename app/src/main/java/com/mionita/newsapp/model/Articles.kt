package com.mionita.newsapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Articles(val source: String,
                    @SerializedName("byline")
                    val author: String,
                    val title: String,
                    @SerializedName("abstract")
                    val description: String,
                    val url: String,
                    @SerializedName("published_date")
                    val publishedAt: Date,
                    val multimedia: List<Multimedia>) {

    fun getUrlToImage(): String {
        if (multimedia.isNullOrEmpty()) {
            return ""
        }
        val jumbo = multimedia.filter { it.format == "superJumbo" }
        val mediumThreeByTwo440 = multimedia.filter { it.format == "mediumThreeByTwo440" }
        val mediumThreeByTwo210 = multimedia.filter { it.format == "mediumThreeByTwo210" }
        val normal = multimedia.filter { it.format == "Normal" }

        when {
            jumbo.isNotEmpty() -> {
                return jumbo[0].url
            }
            mediumThreeByTwo440.isNotEmpty() -> {
                return mediumThreeByTwo440[0].url
            }
            mediumThreeByTwo210.isNotEmpty() -> {
                return mediumThreeByTwo210[0].url
            }
            normal.isNotEmpty() -> {
                return normal[0].url
            }
            else -> {
                return ""
            }
        }
    }
}