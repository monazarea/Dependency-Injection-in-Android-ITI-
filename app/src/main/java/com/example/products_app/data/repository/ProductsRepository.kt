package com.example.di_starterapplication.data.repository

import com.example.products_app.data.model.Product


interface ProductsRepository {
    suspend fun getAllProducts(isOnline: Boolean): List<Product>?
    suspend fun addProduct(product: Product): Long
    suspend fun removeProduct(product: Product): Int
}