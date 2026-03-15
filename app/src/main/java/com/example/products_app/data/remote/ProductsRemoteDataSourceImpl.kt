package com.example.products_app.data.remote

import com.example.products_app.data.model.Product
import javax.inject.Inject

class ProductsRemoteDataSourceImpl @Inject constructor(private val service: ProductService) : RemoteDataSource {
    override suspend fun getAllProducts(): List<Product>?{
        try {
            return service.getAllProducts().body()?.products
        }catch (th: Throwable){
            throw th
        }
    }
}