package com.mlefrapper.foodly.di

import com.mlefrapper.foodly.data.repository.product.IProductRepository
import com.mlefrapper.foodly.data.repository.product.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductRepositoryModule {

    @Provides
    fun provideProductRepository(): IProductRepository {
        return ProductRepository()
    }
}
