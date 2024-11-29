package com.mlefrapper.foodly.di

import com.mlefrapper.foodly.data.repository.product.IProductRepository
import com.mlefrapper.foodly.data.repository.product.ProductRepository
import com.mlefrapper.foodly.data.repository.search.ISearchRepository
import com.mlefrapper.foodly.data.repository.search.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductRepository(): IProductRepository {
        return ProductRepository()
    }

    @Provides
    fun provideSearchRepository(): ISearchRepository {
        return SearchRepository()
    }
}
