package com.mionita.newsapp.model

import com.mionita.newsapp.model.Articles

data class News(
           val num_results: Int,
           val results: List<Articles>) {
}