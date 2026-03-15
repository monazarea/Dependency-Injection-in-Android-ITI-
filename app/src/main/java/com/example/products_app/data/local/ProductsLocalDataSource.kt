package com.example.products_app.data.local

import com.example.products_app.data.model.Product
import javax.inject.Inject

class ProductsLocalDataSource @Inject constructor(private val dao: ProductsDao) : LocalDataSource {
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