package com.molidev8.molirss.domain

data class Everything(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)