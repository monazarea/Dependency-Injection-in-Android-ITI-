package com.example.products_app.data.local

import com.example.products_app.data.model.Product

class ProductsLocalDataSource(private val dao: ProductsDao) : LocalDataSource {
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