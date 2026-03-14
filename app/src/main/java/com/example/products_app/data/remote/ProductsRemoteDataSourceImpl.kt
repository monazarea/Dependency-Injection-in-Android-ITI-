package com.example.products_app.data.remote

import com.example.products_app.data.model.Product

class ProductsRemoteDataSourceImpl(private val service: ProductService) : RemoteDataSource {
    override suspend fun getAllProducts(): List<Product>?{
        try {
            return service.getAllProducts().body()?.products
        }catch (th: Throwable){
            throw th
        }
    }
}