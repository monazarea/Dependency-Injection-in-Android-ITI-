package com.example.products_app.data.local

import com.example.products_app.data.model.Product

interface LocalDataSource {
     suspend fun getAllProducts(): List<Product>

     suspend fun insertProduct(product: Product): Long

     suspend fun deleteProduct(product: Product?): Int
}
