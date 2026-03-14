package com.example.products_app.servicelocator

import android.app.Application
import com.example.di_starterapplication.data.repository.ProductsRepository
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.data.local.LocalDataSource
import com.example.products_app.data.local.ProductsDao
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductService
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RemoteDataSource
import com.example.products_app.data.remote.RetrofitHelper

class ServiceLocator(private  val application: Application) {
    fun provideProductsDao(): ProductsDao {
        return ProductsDataBase.getInstance(application).getProductsDao()
    }

    fun provideProductService(): ProductService {
        return RetrofitHelper.service
    }

    fun provideProductsRemoteDataSource(): RemoteDataSource {
        return ProductsRemoteDataSourceImpl(this)
    }
    fun provideProductsLocalDataSource(): LocalDataSource {
        return ProductsLocalDataSource(this)
    }

    fun provideProductsRepository(): ProductsRepository {
        return ProductsRepositoryImpl.getInstance(this)
    }
}




