package com.mlefrapper.foodly.domain.usecase

import com.mlefrapper.foodly.data.model.SearchResponseDto
import com.mlefrapper.foodly.data.repository.product.IProductRepository
import javax.inject.Inject

class GetProductsByNameUseCase @Inject constructor(
    private val productRepository: IProductRepository,
) {

    suspend operator fun invoke(productName: String): SearchResponseDto {
        return productRepository.getProductsByName(productName)
    }
}
