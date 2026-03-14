package com.example.products_app.data.remote

import com.example.products_app.data.model.Product
import com.example.products_app.servicelocator.ServiceLocator

class ProductsRemoteDataSourceImpl(private val serviceLocator: ServiceLocator) : RemoteDataSource {
    private val service = serviceLocator.provideProductService()

    override suspend fun getAllProducts(): List<Product>?{
        try {
            return service.getAllProducts().body()?.products
        }catch (th: Throwable){
            throw th
        }
    }
}