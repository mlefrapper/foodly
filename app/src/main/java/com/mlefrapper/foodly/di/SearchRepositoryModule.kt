package com.mlefrapper.foodly.di

import com.mlefrapper.foodly.data.repository.search.ISearchRepository
import com.mlefrapper.foodly.data.repository.search.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SearchRepositoryModule {

    @Provides
    fun provideSearchRepository(): ISearchRepository {
        return SearchRepository()
    }
}
