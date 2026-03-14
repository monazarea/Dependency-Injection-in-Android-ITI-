package com.example.di_starterapplication.data.repository

import com.example.products_app.data.local.LocalDataSource
import com.example.products_app.data.model.Product
import com.example.products_app.data.remote.RemoteDataSource


class ProductsRepositoryImpl private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): ProductsRepository {

    override suspend fun getAllProducts(isOnline: Boolean): List<Product>? {
        return if(isOnline){
            remoteDataSource.getAllProducts()
        }else{
            localDataSource.getAllProducts()
        }

    }

    override suspend fun addProduct(product: Product): Long {
        return localDataSource.insertProduct(product)
    }

    override suspend fun removeProduct(product: Product): Int {
        return localDataSource.deleteProduct(product)
    }

    companion object{
        private var INSTANCE : ProductsRepositoryImpl? = null
        fun getInstance(remoteDataSource: RemoteDataSource,
                        localDataSource: LocalDataSource
        ): ProductsRepositoryImpl {
            return INSTANCE ?: synchronized(this){
                val temp = ProductsRepositoryImpl(remoteDataSource, localDataSource)
                INSTANCE = temp
                temp
            }
        }
    }
}