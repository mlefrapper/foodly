package com.mlefrapper.foodly.data.repository.search

import javax.inject.Inject

class SearchRepository @Inject constructor() : ISearchRepository {

    override suspend fun search(query: String): List<String> {
        return listOf("Item 1", "Item 2", "Item 3")
    }
}
