package com.mlefrapper.foodly.data.repository.search

interface ISearchRepository {
    suspend fun search(query: String): List<String>
}
