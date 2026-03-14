package com.example.di_starterapplication.data.repository

import com.example.products_app.data.local.LocalDataSource
import com.example.products_app.data.model.Product
import com.example.products_app.data.remote.RemoteDataSource
import com.example.products_app.servicelocator.ServiceLocator


class ProductsRepositoryImpl private constructor(
    private val serviceLocator: ServiceLocator
): ProductsRepository {
    private val remoteDataSource = serviceLocator.provideProductsRemoteDataSource()
    private val localDataSource = serviceLocator.provideProductsLocalDataSource()

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
        fun getInstance(serviceLocator: ServiceLocator): ProductsRepositoryImpl {
            return INSTANCE ?: synchronized(this){
                val temp = ProductsRepositoryImpl(serviceLocator)
                INSTANCE = temp
                temp
            }
        }
    }
}