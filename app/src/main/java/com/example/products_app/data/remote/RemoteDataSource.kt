package com.example.products_app.data.remote

import com.example.products_app.data.model.Product

interface RemoteDataSource{
    suspend fun getAllProducts(): List<Product>?
}