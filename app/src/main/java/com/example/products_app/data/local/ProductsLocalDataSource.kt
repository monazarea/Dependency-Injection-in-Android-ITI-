package com.example.products_app.data.local

import com.example.products_app.data.model.Product
import com.example.products_app.servicelocator.ServiceLocator

class ProductsLocalDataSource(private val serviceLocator: ServiceLocator) : LocalDataSource {
    private val dao = serviceLocator.provideProductsDao()
    override suspend fun getAllProducts(): List<Product> {
        return dao.getAllFavoriteProducts()
    }

    override suspend fun insertProduct(product: Product): Long {
        return dao.insertProduct(product)
    }

    override suspend fun deleteProduct(product: Product?): Int {
        return if(product!=null)
            dao.deleteProduct(product)
        else
            -1
    }

}