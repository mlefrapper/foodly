package com.mlefrapper.foodly.ui.screen.main.scan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlefrapper.foodly.data.repository.product.IProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScanViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var productRepository: IProductRepository

    fun search(query: String) {
        viewModelScope.launch {
            val product = productRepository.getProduct(query)
        }
    }
}
